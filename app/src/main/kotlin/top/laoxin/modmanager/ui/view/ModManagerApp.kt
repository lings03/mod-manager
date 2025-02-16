package top.laoxin.modmanager.ui.view

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.BitmapDrawable
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
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
import androidx.compose.runtime.*
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
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import top.laoxin.modmanager.App
import top.laoxin.modmanager.R
import top.laoxin.modmanager.ui.state.ModUiState
import top.laoxin.modmanager.ui.state.SettingUiState
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
    @StringRes val title: Int,
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
    val configuration = LocalConfiguration.current

    val settingUiState by settingViewModel.uiState.collectAsState()
    val uiState by modViewModel.uiState.collectAsState()

    var currentPage by remember { mutableIntStateOf(0) }
    var shouldScroll by remember { mutableStateOf(false) }

    Row {
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            NavigationRail(
                currentPage = currentPage,
                onPageSelected = { currentPage = it.apply { shouldScroll = true } },
                modViewModel = modViewModel,
                consoleViewModel = consoleViewModel
            )
        }

        AppContent(
            modViewModel = modViewModel,
            consoleViewModel = consoleViewModel,
            settingViewModel = settingViewModel,
            currentPage = currentPage,
            shouldScroll = shouldScroll,
            configuration = configuration,
            settingUiState = settingUiState,
            uiState = uiState,
            onPageChange = { currentPage = it },
            onScrollComplete = { shouldScroll = false }
        )
    }
}

@Composable
private fun AppContent(
    modViewModel: ModViewModel,
    consoleViewModel: ConsoleViewModel,
    settingViewModel: SettingViewModel,
    currentPage: Int,
    shouldScroll: Boolean,
    configuration: Configuration,
    settingUiState: SettingUiState,
    uiState: ModUiState,
    onPageChange: (Int) -> Unit,
    onScrollComplete: () -> Unit
) {
    val context = LocalContext.current
    val activity = context as? Activity
    val pageList = NavigationIndex.entries

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CurrentTopBar(
                    currentPage,
                    configuration,
                    modViewModel,
                    consoleViewModel,
                    settingViewModel
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    currentPage,
                    configuration,
                    settingUiState,
                    modViewModel,
                    onPageChange
                )
            }
        ) { innerPadding ->
            PageContent(
                innerPadding = innerPadding,
                currentPage = currentPage,
                shouldScroll = shouldScroll,
                pageList = pageList,
                uiState = uiState,
                modViewModel = modViewModel,
                consoleViewModel = consoleViewModel,
                settingViewModel = settingViewModel,
                activity = activity,
                context = context,
                onPageChange = onPageChange,
                onScrollComplete = onScrollComplete
            )
        }
    }
}

// 顶部栏
@Composable
private fun CurrentTopBar(
    currentPage: Int,
    configuration: Configuration,
    modViewModel: ModViewModel,
    consoleViewModel: ConsoleViewModel,
    settingViewModel: SettingViewModel
) {
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
}

// 底部栏
@Composable
private fun BottomNavigationBar(
    currentPage: Int,
    configuration: Configuration,
    settingUiState: SettingUiState,
    modViewModel: ModViewModel,
    onPageChange: (Int) -> Unit
) {
    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        val isAboutVisible =
            currentPage == NavigationIndex.SETTINGS.ordinal && settingUiState.showAbout

        AnimatedVisibility(
            visible = !isAboutVisible,
            modifier = Modifier.navigationBarsPadding(),
            enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
        ) {
            NavigationBar(
                currentPage = currentPage,
                modViewModel = modViewModel,
                onPageSelected = { page ->
                    onPageChange(page)
                }
            )
        }
    }
}

// 页面内容
@Composable
private fun PageContent(
    innerPadding: PaddingValues,
    currentPage: Int,
    shouldScroll: Boolean,
    pageList: List<NavigationIndex>,
    uiState: ModUiState,
    modViewModel: ModViewModel,
    consoleViewModel: ConsoleViewModel,
    settingViewModel: SettingViewModel,
    activity: Activity?,
    context: Context,
    onPageChange: (Int) -> Unit,
    onScrollComplete: () -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = currentPage,
        pageCount = { pageList.size }
    )

    HandleBackActions(currentPage, activity, context, onPageChange)
    SyncPagerState(pagerState, shouldScroll, onPageChange, onScrollComplete)

    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.showTips) {
            ProcessTips(
                text = uiState.tipsText,
                onDismiss = { modViewModel.setShowTips(false) },
                uiState = uiState,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = innerPadding.calculateTopPadding())
                    .zIndex(10f)
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(innerPadding)
                .zIndex(0f)
        ) { page ->
            when (page) {
                NavigationIndex.CONSOLE.ordinal -> ConsolePage(consoleViewModel)
                NavigationIndex.MOD.ordinal -> ModPage(modViewModel)
                NavigationIndex.SETTINGS.ordinal -> SettingPage(settingViewModel)
            }
        }
    }
}

// 处理返回事件
@Composable
private fun HandleBackActions(
    currentPage: Int,
    activity: Activity?,
    context: Context,
    onPageChange: (Int) -> Unit
) {
    val exitToast = remember {
        Toast.makeText(
            context,
            context.getText(R.string.toast_quit_app),
            Toast.LENGTH_SHORT
        )
    }
    var exitTime by remember { mutableLongStateOf(0L) }

    // 控制台页面的退出处理
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

    // 其他页面的返回处理
    BackHandler(enabled = currentPage != NavigationIndex.CONSOLE.ordinal) {
        onPageChange(NavigationIndex.CONSOLE.ordinal)
    }
}

// 同步Pager状态
@Composable
private fun SyncPagerState(
    pagerState: PagerState,
    shouldScroll: Boolean,
    onPageChange: (Int) -> Unit,
    onScrollComplete: () -> Unit
) {
    // 同步Pager状态
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            if (!shouldScroll) {
                onPageChange(page)
            }
        }
    }

    // 处理页面滚动
    LaunchedEffect(pagerState.currentPage) {
        if (shouldScroll) {
            pagerState.animateScrollToPage(
                page = pagerState.currentPage,
                animationSpec = tween(
                    durationMillis = abs(pagerState.currentPage - pagerState.targetPage) * 100 + 200,
                    easing = FastOutSlowInEasing
                )
            )
            onScrollComplete()
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
            .padding(0.dp)
            .width(72.dp),
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
                        if ((currentTime - lastClickTime) < 300 && isSelected) {
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
                    if ((currentTime - lastClickTime) < 300 && isSelected) {
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

// 刷新逻辑
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
                Bitmap.createBitmap(
                    drawable.intrinsicWidth,
                    drawable.intrinsicHeight,
                    Bitmap.Config.ARGB_8888
                ).also { bitmap ->
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
