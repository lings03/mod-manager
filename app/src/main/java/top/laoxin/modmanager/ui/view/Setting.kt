package top.laoxin.modmanager.ui.view

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import top.laoxin.modmanager.R
import top.laoxin.modmanager.bean.GameInfo
import top.laoxin.modmanager.constant.GameInfoConstant
import top.laoxin.modmanager.tools.ModTools
import top.laoxin.modmanager.ui.view.commen.DialogCommon
import top.laoxin.modmanager.ui.viewmodel.SettingUiState
import top.laoxin.modmanager.ui.viewmodel.SettingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingPage() {
    val viewModel: SettingViewModel = viewModel(
        factory = SettingViewModel.Factory
    )
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                title = {
                    Text(
                        stringResource(id = R.string.settings),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
    ) { innerPadding ->
        SettingContent(
            innerPadding,
            uiState,
            viewModel::setDeleteBackupDialog,
            viewModel::deleteAllBackups,
            viewModel::deleteCache,
            viewModel::deleteTemp,
            viewModel::openUrl,
            viewModel::showAcknowledgments,
            viewModel::showSwitchGame,
            viewModel::flashGameConfig,
            viewModel::checkUpdate
        )
        DialogCommon(
            title = stringResource(R.string.setting_acknowledgments),
            content = stringResource(R.string.setting_acknowledgments_content),
            onConfirm = { viewModel.showAcknowledgments(false) },
            onCancel = { viewModel.showAcknowledgments(false) },
            showDialog = uiState.showAcknowledgments
        )
        SwitchGameDialog(
            gameInfoList = uiState.gameInfoList,
            setGameInfo = viewModel::setGameInfo,
            showSwitchGameInfo = viewModel::showSwitchGame,
            showDialog = uiState.showSwitchGame
        )
    }
}


@Composable
fun SettingContent(
    paddingValues: PaddingValues,
    uiState: SettingUiState,
    setDeleteBackupDialog: (Boolean) -> Unit,
    deleteAllBackups: () -> Unit,
    deleteCache: () -> Unit,
    deleteTemp: () -> Unit,
    openUrl: (Context, String) -> Unit,
    showAcknowledgments: (Boolean) -> Unit,
    showSwitchGame: (Boolean) -> Unit,
    flashGameConfig : () -> Unit,
    checkUpdate : () -> Unit
) {
    val context = LocalContext.current
    DialogCommon(
        title = stringResource(R.string.setting_del_backups_dialog_title),
        content = stringResource(R.string.setting_del_backups_dialog_content_txt),
        onConfirm = { deleteAllBackups() },
        onCancel = { setDeleteBackupDialog(false) },
        showDialog = uiState.deleteBackupDialog,
    )
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SettingTitle(
            stringResource(R.string.setting_page_app_title),
            Icons.Default.Settings
        ) // 添加一个设置项
        // 添加一个设置项
        SettingItem(
            name = stringResource(R.string.setting_page_app_del_backup),
            description = stringResource(R.string.setting_page_app_del_descript),
            onClick = { setDeleteBackupDialog(true) }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_app_clean_cache),
            description = stringResource(R.string.setting_page_app_clean_cache_descript),
            onClick = { deleteCache() }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_app_clean_temp),
            description = stringResource(R.string.setting_page_app_clean_temp_descript),
            onClick = { deleteTemp() }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_app_flash_game_config),
            description = stringResource(R.string.setting_page_app_flash_game_config_descript),
            onClick = { flashGameConfig() }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_app_swtch_game),
            description = stringResource(R.string.setting_page_app_swtch_game_descript),
            onClick = { showSwitchGame(true) }
        )

        SettingTitle(stringResource(R.string.setting_page_about_title), Icons.Default.Info)
        SettingItem(
            name = stringResource(R.string.setting_page_about_author),
            description = stringResource(R.string.setting_page_about_github),
            icon = painterResource(id = R.drawable.github_icon),
            onClick = {
                openUrl(context, context.getString(R.string.github_url))
            }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_about_pay),
            description = stringResource(R.string.setting_page_about_pay_descript),
            icon = painterResource(id = R.drawable.alipay_icon),
            onClick = {
                openUrl(context, context.getString(R.string.alipay_url))
            }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_about_update),
            description = stringResource(R.string.setting_page_about_update_descript, uiState.versionName),
            icon = painterResource(id = R.drawable.update_icon),
            onClick = {
                checkUpdate()
            }
        )
        SettingTitle(
            stringResource(R.string.setting_page_app_other),
            Icons.Default.MoreVert
        )
        SettingItem(
            name = stringResource(R.string.setting_page_more_shizuku),
            description = stringResource(R.string.setting_page_more_shizuku_descript),
            icon = painterResource(id = R.drawable.shizuku_icon),
            onClick = {
                openUrl(context, context.getString(R.string.shzuiku_url))
            }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_more_reference),
            description = stringResource(R.string.setting_page_more_reference_descript),
            icon = painterResource(id = R.drawable.book_icon),
            onClick = {
                openUrl(context, context.getString(R.string.reference_url))
            }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_more_qq),
            description = stringResource(R.string.setting_page_more_qq_descript),
            icon = painterResource(id = R.drawable.qq_icon),
            onClick = {
                openUrl(context, context.getString(R.string.qq_url))
            }
        )
        SettingItem(
            name = stringResource(R.string.setting_page_more_acknowledgments),
            description = stringResource(R.string.setting_page_more_acknowledgments_descript),
            icon = painterResource(id = R.drawable.thank_icon),
            onClick = {
                showAcknowledgments(true)
            }
        )
    }
}


@Composable
fun SettingItem(
    name: String,
    description: String,
    icon: Painter? = null,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(32.dp),
                )
            }

            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleSmall // 更大的字体
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall // 较小的字体
                )
            }
        }
    }


}

@Composable
fun SettingTitle(
    title: String,
    icon: ImageVector
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(60.dp),
    ) {
        // 图标

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            // modifier = Modifier.align(Alignment.CenterStart),
            color = MaterialTheme.colorScheme.primary
        )
    }


}

// 切换游戏版本的弹窗
@Composable
fun SwitchGameDialog(
    gameInfoList: List<GameInfo>,
    setGameInfo: (GameInfo) -> Unit,
    showSwitchGameInfo: (Boolean) -> Unit,
    showDialog: Boolean
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {showSwitchGameInfo(false)}, // 点击对话框外的区域时关闭对话框
            title = { Text(text = stringResource(R.string.switch_game_service_tiltle)) },
            text = {
                val toMutableList = gameInfoList.toMutableList()
                toMutableList.removeAt(0)

                LazyColumn {
                    itemsIndexed(toMutableList) { index, gameInfo ->
                        SettingItem(
                            name = gameInfo.gameName + "(${gameInfo.serviceName})",
                            description = gameInfo.packageName,
                            //icon = painterResource(id = R.drawable.ic_launcher_foreground),
                            onClick = {
                                setGameInfo(gameInfo)
                                showSwitchGameInfo(false)
                            }
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    showSwitchGameInfo(false)
                }) {
                    Text(text = stringResource(R.string.mod_page_mod_detail_dialog_close))
                }
            }
        )

    }

}

@Preview
@Composable
fun PreviewSettingPage() {

}
