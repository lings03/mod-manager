package top.laoxin.modmanager.ui.view.modView

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Deselect
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SelectAll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import top.laoxin.modmanager.R
import top.laoxin.modmanager.ui.state.ModUiState
import top.laoxin.modmanager.ui.view.commen.DialogCommon
import top.laoxin.modmanager.ui.viewmodel.ModViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModTopBar(viewModel: ModViewModel, modifier: Modifier = Modifier, configuration: Int) {
    val uiState by viewModel.uiState.collectAsState()
    if (uiState.isMultiSelect) {
        DialogCommon(
            title = stringResource(R.string.dialog_del_selected_mods_title),
            content = stringResource(R.string.dialog_del_selected_mods_content),
            onConfirm = { viewModel.delSelectedMods() },
            onCancel = { viewModel.setShowDelSelectModsDialog(false) },
            showDialog = uiState.showDelSelectModsDialog
        )
        MultiSelectTopBar(viewModel, uiState, modifier = modifier, configuration = configuration)
    } else {
        GeneralTopBar(viewModel, uiState, modifier = modifier, configuration = configuration)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiSelectTopBar(
    viewModel: ModViewModel,
    uiState: ModUiState,
    modifier: Modifier,
    configuration: Int
) {
    val modList = when (uiState.modsView) {
        NavigationIndex.ALL_MODS -> uiState.modList
        NavigationIndex.ENABLE_MODS -> uiState.enableModList
        NavigationIndex.DISABLE_MODS -> uiState.disableModList
        NavigationIndex.SEARCH_MODS -> uiState.searchModList
        NavigationIndex.MODS_BROWSER -> uiState.currentMods
    }
    Column {
        TopAppBar(
            modifier = modifier,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (configuration == Configuration.ORIENTATION_LANDSCAPE) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceContainer,
            ),
            title = {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = if (uiState.modsView == NavigationIndex.MODS_BROWSER)
                        Modifier.padding(start = 6.dp)
                    else
                        Modifier
                ) {
                    Text(
                        stringResource(id = uiState.modsView.title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                        Row(
                            modifier = Modifier.padding(top = 40.dp),
                        ) {
                            val total =
                                if (uiState.modsSelected.isNotEmpty()) "${uiState.modsSelected.size}/${modList.size}"
                                else "${modList.size}"

                            Text(
                                text = stringResource(R.string.mod_top_bar_count, total),
                                style = MaterialTheme.typography.labelMedium,
                                // color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Start,
                            )
                        }

                    }
                }

            },
            actions = {
                // 全选
                IconButton(onClick = {
                    // 在这里处理图标按钮的点击事件
                    viewModel.allSelect(modList)
                }) {
                    Icon(
                        imageVector = Icons.Default.SelectAll, // 使用信息图标
                        contentDescription = "Info", // 为辅助功能提供描述
                        //tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                // 取消选择
                IconButton(onClick = {
                    // 在这里处理图标按钮的点击事件
                    viewModel.deselect()
                }) {
                    Icon(
                        imageVector = Icons.Default.Deselect, // 使用信息图标
                        contentDescription = "Info", // 为辅助功能提供描述
                        //tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                IconButton(onClick = {
                    // 在这里处理图标按钮的点击事件
                    viewModel.switchSelectMod(modList, true)
                }) {
                    Icon(
                        imageVector = Icons.Default.FlashOn, // 使用信息图标
                        contentDescription = "Info", // 为辅助功能提供描述
                        //tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                IconButton(onClick = {
                    viewModel.switchSelectMod(modList, false)

                    // 请求焦点
                }, modifier = Modifier) {
                    Icon(
                        imageVector = Icons.Filled.FlashOff, contentDescription = null,
                        //tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                IconButton(onClick = {
                    viewModel.delSelectedMods()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Delete, // 使用刷新图标
                        contentDescription = "Refresh", // 为辅助功能提供描述
                        //tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                IconButton(onClick = { viewModel.exitSelect() }, modifier = Modifier) {
                    Icon(
                        imageVector = Icons.Filled.Close, contentDescription = null,
                        //tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            })

        // 显示或隐藏搜索框
        AnimatedVisibility(visible = uiState.searchBoxVisible) {
            SearchBox(
                text = viewModel.getSearchText(),
                onValueChange = { viewModel.setSearchText(it) },
                hint = stringResource(R.string.mod_page_search_hit),
                visible = uiState.searchBoxVisible,
                onClose = {
                    viewModel.setSearchBoxVisible(false)

                    when (uiState.modsView) {
                        NavigationIndex.MODS_BROWSER -> viewModel.setModsView(NavigationIndex.MODS_BROWSER)
                        else -> viewModel.setModsView(NavigationIndex.ALL_MODS)
                    }
                    // 清空搜索框
                    viewModel.setSearchText("")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralTopBar(
    viewModel: ModViewModel,
    uiState: ModUiState,
    modifier: Modifier,
    configuration: Int
) {
    val modList = when (uiState.modsView) {
        NavigationIndex.ALL_MODS -> uiState.modList
        NavigationIndex.ENABLE_MODS -> uiState.enableModList
        NavigationIndex.DISABLE_MODS -> uiState.disableModList
        NavigationIndex.SEARCH_MODS -> uiState.searchModList
        NavigationIndex.MODS_BROWSER -> uiState.currentMods
    }
    var showMenu by remember { mutableStateOf(false) }

    // 简化逻辑，直接使用uiState.isBackPathExist
    val backButtonEnabled = uiState.isBackPathExist

    // 添加按钮透明度动画
    val backButtonAlpha by animateFloatAsState(
        targetValue = if (backButtonEnabled) 1f else 0.5f,
        label = "backButtonAlpha"
    )

    Column {
        TopAppBar(
            modifier = modifier,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (configuration == Configuration.ORIENTATION_LANDSCAPE) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceContainer,
            ),
            navigationIcon = {
                if (uiState.modsView == NavigationIndex.MODS_BROWSER)
                    Button(
                        onClick = {
                            // 只在按钮可用时触发返回功能
                            if (backButtonEnabled) {
                                viewModel.setDoBackFunction(true)
                            }
                        },
                        modifier = Modifier
                            .size(35.dp)
                            .padding(start = 6.dp)
                            .offset(y = 8.dp)
                            .alpha(backButtonAlpha),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(0.dp),
                        // 将按钮的启用状态与backButtonEnabled绑定
                        enabled = backButtonEnabled,
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBackIosNew,
                                contentDescription = "back",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                else null
            },
            title = {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = if (uiState.modsView == NavigationIndex.MODS_BROWSER)
                        Modifier.padding(start = 6.dp)
                    else
                        Modifier
                ) {
                    Text(
                        stringResource(id = uiState.modsView.title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Box {
                        Row(
                            modifier = Modifier.padding(top = 40.dp),
                        ) {

                            val total =
                                if (uiState.modsSelected.isNotEmpty()) "${uiState.modsSelected.size}/${modList.size}" else "${modList.size}"

                            Text(
                                text = stringResource(R.string.mod_top_bar_count, total),
                                style = MaterialTheme.typography.labelMedium,
                                //color = MaterialTheme.colorScheme.onPrimary,
                                textAlign = TextAlign.Start,
                            )
                        }

                    }
                }

            },
            actions = {
                IconButton(onClick = {
                    viewModel.setSearchBoxVisible(true)
                    when (uiState.modsView) {
                        NavigationIndex.MODS_BROWSER -> viewModel.setModsView(NavigationIndex.MODS_BROWSER)
                        else -> viewModel.setModsView(NavigationIndex.SEARCH_MODS)
                    }

                    // 请求焦点
                }, modifier = Modifier) {
                    Icon(
                        imageVector = Icons.Filled.Search, contentDescription = null,
                        // tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                IconButton(onClick = {
                    viewModel.flashMods(true, false)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh, // 使用刷新图标
                        contentDescription = "Refresh", // 为辅助功能提供描述
                    )
                }
                IconButton(onClick = {
                    viewModel.setShowForceScanDialog(true)
                }) {
                    Icon(
                        imageVector = Icons.Filled.RestartAlt, // 使用刷新图标
                        contentDescription = "ForceRefresh", // 为辅助功能提供描述
                    )
                }
                IconButton(onClick = { showMenu = true }, modifier = Modifier) {
                    Icon(
                        imageVector = Icons.Filled.Menu, contentDescription = null,
                        // tint = MaterialTheme.colorScheme.primaryContainer
                    )
                }
                AnimatedVisibility(visible = showMenu, modifier = Modifier.offset(y = 20.dp)) {
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.mod_page_dropdownMenu_show_enable_mods)) },
                            onClick = {
                                viewModel.setModsView(NavigationIndex.ENABLE_MODS)
                                showMenu = false
                            })
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.mod_page_dropdownMenu_show_disable_mods)) },
                            onClick = {
                                viewModel.setModsView(NavigationIndex.DISABLE_MODS)
                                showMenu = false
                            })
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.mod_page_dropdownMenu_show_all_mods)) },
                            onClick = {
                                viewModel.setModsView(NavigationIndex.ALL_MODS)
                                showMenu = false
                            })
                        DropdownMenuItem(
                            text = { Text(stringResource(R.string.mod_page_dropdownMenu_mods_browser)) },
                            onClick = {
                                viewModel.setModsView(NavigationIndex.MODS_BROWSER)
                                showMenu = false
                            })

                        // 添加更多的菜单项
                    }
                }
            }
        )

        // 显示或隐藏搜索框
        AnimatedVisibility(visible = uiState.searchBoxVisible) {
            SearchBox(
                text = viewModel.getSearchText(),
                onValueChange = { viewModel.setSearchText(it) },
                hint = stringResource(R.string.mod_page_search_hit),
                visible = uiState.searchBoxVisible,
                onClose = {
                    viewModel.setSearchBoxVisible(false)
                    when (uiState.modsView) {
                        NavigationIndex.MODS_BROWSER -> viewModel.setModsView(NavigationIndex.MODS_BROWSER)
                        else -> viewModel.setModsView(NavigationIndex.ALL_MODS)
                    }
                    // 清空搜索框
                    viewModel.setSearchText("")
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    text: String,
    onValueChange: (String) -> Unit,
    hint: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    visible: Boolean
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val onValueChangeCallback = remember(onValueChange) { onValueChange }
    val onCloseCallback = remember(onClose) { onClose }

    LaunchedEffect(visible) {
        if (visible) {
            delay(100)
            focusRequester.requestFocus()
            keyboardController?.show()
        } else {
            keyboardController?.hide()
        }
    }

    val textStyle = MaterialTheme.typography.bodyMedium
    val placeholderStyle = MaterialTheme.typography.bodyMedium.copy(
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )


    val shape = MaterialTheme.shapes.medium
    val colors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )

    val keyboardActions = remember {
        KeyboardActions(onDone = { keyboardController?.hide() })
    }

    TextField(
        value = text,
        onValueChange = onValueChangeCallback,
        placeholder = { Text(text = hint, style = placeholderStyle) },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp)
            .height(50.dp)
            .focusRequester(focusRequester),
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = keyboardActions,
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = onCloseCallback) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "关闭搜索"
                )
            }
        },
        shape = shape,
        colors = colors
    )
}

