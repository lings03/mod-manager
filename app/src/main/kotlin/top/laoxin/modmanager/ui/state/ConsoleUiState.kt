package top.laoxin.modmanager.ui.state

import top.laoxin.modmanager.constant.GameInfoConstant
import top.laoxin.modmanager.data.bean.GameInfoBean
import top.laoxin.modmanager.data.bean.InfoBean

data class ConsoleUiState(
    var antiHarmony: Boolean = false,
    var scanQQDirectory: Boolean = false,
    var selectedDirectory: String = "未选择",
    val scanDownload: Boolean = false,
    val openPermissionRequestDialog: Boolean = false,
    // mod数量
    val modCount: Int = 0,
    // 已开启mod数量
    val enableModCount: Int = 0,
    // 扫描文件夹中的Mods
    val scanDirectoryMods: Boolean = true,
    // 游戏信息
    val gameInfo: GameInfoBean = GameInfoConstant.gameInfoList[0],
    // 是否可以安装mod
    val canInstallMod: Boolean = false,
    // 是否显示扫描文件夹中的Mods对话框
    val showScanDirectoryModsDialog: Boolean = false,
    // 显示升级弹窗
    val showUpgradeDialog: Boolean = false,
    // 显示信息弹窗
    val showInfoDialog: Boolean = false,
    // 信息弹窗内容
    val infoBean: InfoBean = InfoBean(0.0, ""),
    // 显示删除解压目录弹窗
    val showDeleteUnzipDialog: Boolean = false,
    // 自动删除解压目录
    val delUnzipDictionary: Boolean = false,
    // 展示分类视图
    val showCategoryView: Boolean = true,
)