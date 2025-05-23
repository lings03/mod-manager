package top.laoxin.modmanager.ui.view

import android.app.Activity
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.BitmapDrawable
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.ImagesearchRoller
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.graphics.createBitmap
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import top.laoxin.modmanager.App
import top.laoxin.modmanager.R
import top.laoxin.modmanager.ui.state.ModUiState
import top.laoxin.modmanager.ui.view.modView.ModPage
import top.laoxin.modmanager.ui.view.modView.ModTopBar
import top.laoxin.modmanager.ui.view.settingView.SettingPage
import top.laoxin.modmanager.ui.view.settingView.SettingTopBar
import top.laoxin.modmanager.ui.viewmodel.ConsoleViewModel
import top.laoxin.modmanager.ui.viewmodel.ModViewModel
import top.laoxin.modmanager.ui.viewmodel.SettingViewModel
import kotlin.math.abs

// 导航栏索引
enum class NavigationIndex(
    @param:StringRes val title: Int,
    val icon: ImageVector,
) {
    CONSOLE(R.string.console, Icons.Filled.Dashboard),
    MOD(R.string.mod, Icons.Filled.ImagesearchRoller),
    SETTINGS(R.string.settings, Icons.Filled.Settings)
}

@Composable
fun ModManagerApp() {
    val modViewModel: ModViewModel = viewModel()
    val consoleViewModel: ConsoleViewModel = viewModel()
    val settingViewModel: SettingViewModel = viewModel()
    val pageList = NavigationIndex.entries
    val configuration = LocalConfiguration.current
    val navigationBarHeight = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    val settingUiState = settingViewModel.uiState.collectAsState().value

    var exitTime by rememberSaveable { mutableLongStateOf(0L) }
    var currentPage by rememberSaveable { mutableIntStateOf(0) }
    var shouldScroll by remember { mutableStateOf(false) }
    var hideBottomBar by remember { mutableStateOf(false) }

    LaunchedEffect(settingUiState.showAbout) {
        if (!settingUiState.showAbout) {
            hideBottomBar = false
        }
    }

    // 创建并记忆 PagerState，避免重组时重新创建
    val pagerState = rememberPagerState(
        initialPage = currentPage,
        pageCount = { pageList.size }
    )

    Row {
        // 在横向模式下显示侧边导航栏
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            NavigationRail(
                currentPage = currentPage,
                onPageSelected = { page ->
                    currentPage = page
                    shouldScroll = true
                },
                modViewModel = modViewModel,
                consoleViewModel = consoleViewModel
            )
        }

        Scaffold(
            // 根据当前页面显示不同的顶部工具栏
            topBar = {
                when (currentPage) {
                    NavigationIndex.CONSOLE.ordinal -> ConsoleTopBar(
                        consoleViewModel,
                        configuration = configuration.orientation
                    )

                    NavigationIndex.MOD.ordinal -> ModTopBar(
                        modViewModel,
                        configuration = configuration.orientation
                    )

                    NavigationIndex.SETTINGS.ordinal -> SettingTopBar(
                        settingViewModel,
                        configuration = configuration.orientation
                    )
                }
            },
            // 在纵向模式下显示底部导航栏
            bottomBar = {
                if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateContentSize()
                            .height(
                                if (hideBottomBar) 0.dp
                                else 80.dp + navigationBarHeight
                            )
                    ) {
                        if (!hideBottomBar) {
                            NavigationBar(
                                currentPage = currentPage,
                                modViewModel = modViewModel,
                                onPageSelected = { page ->
                                    currentPage = page
                                    shouldScroll = true
                                }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            val context = LocalContext.current
            val exitToast: Toast =
                remember {
                    Toast.makeText(
                        context,
                        context.getText(R.string.toast_quit_app),
                        Toast.LENGTH_SHORT
                    )
                }
            val activity = context as? Activity
            val modViewUiState = modViewModel.uiState.collectAsState().value

            // 在 ConsolePage 显示退出确认
            BackHandler(enabled = currentPage == NavigationIndex.CONSOLE.ordinal) {
                val currentTime = System.currentTimeMillis()
                if (currentTime - exitTime > 2000) {
                    exitToast.show()
                    exitTime = currentTime
                } else {
                    exitToast.cancel()
                    activity?.finish()
                }
            }

            // 在 ModPage 显示搜索框时，优先隐藏搜索框，并阻止其他返回逻辑
            if (currentPage == NavigationIndex.MOD.ordinal && modViewUiState.searchBoxVisible) {
                BackHandler {
                    modViewModel.setSearchBoxVisible(false)
                }
            }
            // 在其他页面，返回键跳转到 ConsolePage
            else if (currentPage != NavigationIndex.CONSOLE.ordinal) {
                BackHandler {
                    currentPage = NavigationIndex.CONSOLE.ordinal
                    shouldScroll = true
                }
            }

            // 优化页面切换逻辑，减少不必要的动画
            LaunchedEffect(currentPage, shouldScroll) {
                if (shouldScroll) {
                    // 添加短暂延迟以确保状态已更新
                    delay(10)
                    val targetPage = currentPage
                    val currentPagerPage = pagerState.currentPage
                    if (targetPage != currentPagerPage) {
                        pagerState.animateScrollToPage(
                            page = targetPage,
                            animationSpec = tween(
                                durationMillis = abs(currentPagerPage - targetPage) * 100 + 200,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                    shouldScroll = false
                }
            }

            // 使用derivedStateOf优化，减少不必要的重组
            val currentPagerPage by remember {
                derivedStateOf { pagerState.currentPage }
            }

            // 当PagerState的当前页面改变时更新currentPage
            LaunchedEffect(currentPagerPage) {
                if (!shouldScroll && currentPage != currentPagerPage) {
                    currentPage = currentPagerPage
                }
            }

            // 页面内容
            Box(modifier = Modifier.fillMaxSize()) {
                // 显示进度
                if (modViewUiState.showTips) {
                    ProcessTips(
                        text = modViewUiState.tipsText,
                        onDismiss = { modViewModel.setShowTips(false) },
                        uiState = modViewUiState,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = innerPadding.calculateTopPadding())
                            .zIndex(10f)
                    )
                }

                // 每个页面显示的内容
                AppContent(
                    pagerState = pagerState,
                    modifier = Modifier
                        .padding(innerPadding)
                        .zIndex(0f),
                    consoleViewModel = consoleViewModel,
                    modViewModel = modViewModel,
                    settingViewModel = settingViewModel,
                    onHideBottomBar = { hideBottomBar = it }
                )
            }
        }
    }
}

@Composable
fun AppContent(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    consoleViewModel: ConsoleViewModel,
    modViewModel: ModViewModel,
    settingViewModel: SettingViewModel,
    onHideBottomBar: (Boolean) -> Unit
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        // 添加键以优化重组
        key = { page -> "page_$page" }
    ) { page ->
        when (page) {
            NavigationIndex.CONSOLE.ordinal -> ConsolePage(consoleViewModel)
            NavigationIndex.MOD.ordinal -> ModPage(modViewModel)
            NavigationIndex.SETTINGS.ordinal -> SettingPage(settingViewModel, onHideBottomBar)
        }
    }
}

//侧边导航
@Composable
fun NavigationRail(
    currentPage: Int,
    onPageSelected: (Int) -> Unit,
    modViewModel: ModViewModel,
    consoleViewModel: ConsoleViewModel
) {
    var lastClickTime by remember { mutableLongStateOf(0L) }
    val packageName = consoleViewModel.uiState.collectAsState().value.gameInfo.packageName
    val gameIcon = remember(packageName) {
        getGameIcon(packageName)
    }

    NavigationRail(
        modifier = Modifier
            .fillMaxHeight()
            .width(90.dp)
            .padding(0.dp)
    ) {
        val currentPageName = stringResource(id = NavigationIndex.entries[currentPage].title)
        Text(
            text = currentPageName,
            modifier = Modifier.padding(16.dp)
        )
        Column {
            NavigationIndex.entries.forEachIndexed { index, navigationItem ->
                val isSelected = currentPage == index

                NavigationRailItem(
                    selected = isSelected,
                    onClick = {
                        val currentTime = System.currentTimeMillis()
                        if (isSelected && (currentTime - lastClickTime) < 300) {
                            refreshCurrentPage(currentPage, modViewModel)
                        } else {
                            // 非双击或者是切换页面时，执行页面切换
                            modViewModel.exitSelect()
                            if (!isSelected) {
                                onPageSelected(index)
                            }
                        }
                        lastClickTime = currentTime
                    },
                    icon = {
                        // 显示图标
                        Icon(imageVector = navigationItem.icon, contentDescription = null)
                    },
                    label = {
                        // 标签文字，仅在选中时显示
                        AnimatedVisibility(
                            visible = isSelected,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            Text(text = stringResource(id = navigationItem.title))
                        }
                    },
                    alwaysShowLabel = false
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            gameIcon?.let {
                Image(
                    bitmap = it,
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                )
            }
        }
    }
}

// 底部导航
@Composable
fun NavigationBar(
    currentPage: Int,
    modViewModel: ModViewModel,
    onPageSelected: (Int) -> Unit
) {
    var lastClickTime by remember { mutableLongStateOf(0L) }

    NavigationBar {
        NavigationIndex.entries.forEachIndexed { index, navigationItem ->
            val isSelected = currentPage == index

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    val currentTime = System.currentTimeMillis()
                    if (isSelected && (currentTime - lastClickTime) < 300) {
                        refreshCurrentPage(currentPage, modViewModel)
                    } else {
                        // 非双击或者是切换页面时，执行页面切换
                        modViewModel.exitSelect()
                        if (!isSelected) {
                            onPageSelected(index)
                        }
                    }
                    lastClickTime = currentTime
                },
                icon = {
                    // 显示图标
                    Icon(imageVector = navigationItem.icon, contentDescription = null)
                },
                label = {
                    // 标签文字，仅在选中时显示
                    AnimatedVisibility(
                        visible = isSelected,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Text(text = stringResource(id = navigationItem.title))
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}

private fun refreshCurrentPage(currentPage: Int, modViewModel: ModViewModel) {
    // 根据当前页面的类型，执行相应的刷新逻辑
    when (currentPage) {
        NavigationIndex.CONSOLE.ordinal -> {}

        NavigationIndex.MOD.ordinal -> {
            modViewModel.flashMods(true, false)
        }

        NavigationIndex.SETTINGS.ordinal -> {}
    }
}

// 获取应用图标
fun getGameIcon(packageName: String): ImageBitmap? {
    var packageName = packageName
    if (packageName.isEmpty() || packageName == "null") {
        packageName = App.get().packageName
    }
    try {
        val packageInfo = App.get().packageManager.getPackageInfo(packageName, 0)
        var drawable = packageInfo.applicationInfo?.loadIcon(App.get().packageManager)
        val bitmap = when (drawable) {
            is BitmapDrawable -> drawable.bitmap
            is AdaptiveIconDrawable -> {
                createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight).also { bitmap ->
                    val canvas = Canvas(bitmap)
                    drawable.setBounds(0, 0, canvas.width, canvas.height)
                    drawable.draw(canvas)
                }
            }

            else -> {
                val context = App.get()
                drawable = context.resources.getDrawable(R.drawable.app_icon, context.theme)
                drawable.toBitmap()
            }
        }
        return bitmap.asImageBitmap()
    } catch (_: PackageManager.NameNotFoundException) {
        val context = App.get()
        val drawable = context.resources.getDrawable(R.drawable.app_icon, context.theme)
        val bitmap = drawable.toBitmap()
        return bitmap.asImageBitmap()
    }
}

@Composable
fun ProcessTips(
    text: String,
    onDismiss: () -> Unit,
    uiState: ModUiState,
    modifier: Modifier
) {
    // 构建提示文本
    val tipsStart =
        if (uiState.unzipProgress.isNotEmpty()) {
            "$text : ${uiState.unzipProgress}"
        } else {
            text
        }

    val tipsEnd =
        if (uiState.multitaskingProgress.isNotEmpty()) {
            stringResource(R.string.mod_top_bar_tips, uiState.multitaskingProgress)
        } else {
            ""
        }

    // 显示提示
    Box(modifier.fillMaxWidth(0.7f)) {
        Snackbar(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            action = {
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.padding(4.dp),
                    contentPadding = PaddingValues(horizontal = 2.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = stringResource(R.string.tips_btn_close),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        ) {
            Text(
                text = "$tipsStart $tipsEnd",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Center
            )
        }
    }

}
