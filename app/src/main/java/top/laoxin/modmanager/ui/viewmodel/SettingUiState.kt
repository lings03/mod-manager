package top.laoxin.modmanager.ui.viewmodel

import top.laoxin.modmanager.bean.GameInfo

data class SettingUiState(
    // 删除备份对话框
    val deleteBackupDialog: Boolean = false,
    val showAcknowledgments: Boolean = false,
    val showSwitchGame: Boolean = false,
    val gameInfoList: List<GameInfo> = emptyList(),
    // 更新弹窗
    val showUpdateDialog: Boolean = false,
    // 当前的versionName
    val versionName: String = "",
)