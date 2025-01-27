package top.laoxin.modmanager.ui.view.modView

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import top.laoxin.modmanager.R
import top.laoxin.modmanager.bean.ModBean
import top.laoxin.modmanager.ui.theme.ModManagerTheme
import top.laoxin.modmanager.ui.view.commen.DialogCommon
import top.laoxin.modmanager.ui.view.commen.SelectPermissionDialog
import top.laoxin.modmanager.ui.viewmodel.ModViewModel

//lateinit var viewModel: ModViewModel
enum class NavigationIndex(
    @StringRes val title: Int,
    val index: Int,
) {
    ALL_MODS(R.string.mod_page_title_all_mods, 0),
    ENABLE_MODS(R.string.mod_page_title_enable_mods, 1),
    DISABLE_MODS(R.string.mod_page_title_disable_mods, 2),
    SEARCH_MODS(R.string.mod_page_title_search_mods, 3),
    MODS_BROWSER(R.string.mod_page_title_mods_browser, 4),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModPage(viewModel: ModViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Box {
        DisEnableModsDialog(
            showDialog = uiState.showDisEnableModsDialog,
            mods = uiState.delEnableModsList,
            switchMod = { mod, enable -> viewModel.switchMod(mod, enable, true) },
            onConfirmRequest = {
                viewModel.delMods()
            },
            viewModel = viewModel
        )
        DialogCommon(
            title = stringResource(R.string.open_mod_failed_dialog_title),
            content = stringResource(
                R.string.open_mod_failed_dialog_desc,
                uiState.openFailedMods.size
            ),
            onConfirm = {
                viewModel.setShowOpenFailedDialog(false)
                viewModel.disableMod(uiState.openFailedMods, false)
            },
            onCancel = { viewModel.setShowOpenFailedDialog(false) },
            showDialog = uiState.showOpenFailedDialog
        )

        if (viewModel.requestPermissionPath.isNotEmpty()) {
            SelectPermissionDialog(
                path = viewModel.requestPermissionPath,
                onDismissRequest = { viewModel.setOpenPermissionRequestDialog(false) },
                showDialog = uiState.openPermissionRequestDialog
            )
        }
        if (uiState.isLoading) {
            Loading(uiState.loadingPath)
        } else {
            uiState.modDetail?.let {
                ModDetailPartialBottomSheet(
                    showDialog = uiState.showModDetail,
                    mod = it,
                    viewModel = viewModel,
                    onDismiss = { viewModel.setShowModDetail(false) }
                )
                PasswordInputDialog(
                    showDialog = uiState.showPasswordDialog,
                    onDismiss = { viewModel.showPasswordDialog(false) },
                    onPasswordSubmit = viewModel::checkPassword
                )
            }
            when (uiState.modsView) {
                NavigationIndex.MODS_BROWSER -> ModsBrowser(viewModel, uiState)
                else -> AllModPage(viewModel, uiState)
            }
        }
    }
}

// 关闭mods提示框
@Composable
fun DisEnableModsDialog(
    showDialog: Boolean,
    mods: List<ModBean>,
    switchMod: (ModBean, Boolean) -> Unit,
    onConfirmRequest: () -> Unit,
    viewModel: ModViewModel
) {
    if (showDialog) {
        if (mods.isNotEmpty()) {
            AlertDialog(
                onDismissRequest = {},
                title = {
                    Text(
                        stringResource(id = R.string.dialog_dis_enable_mods_title),
                        style = MaterialTheme.typography.titleSmall
                    )
                },
                text = {
                    LazyColumn {
                        itemsIndexed(mods) { _, mod ->
                            ModListItem(
                                mod = mod,
                                modSwitchEnable = true,
                                openModDetail = { _, _ -> },
                                enableMod = switchMod,
                                isMultiSelect = false,
                                onLongClick = { },
                                onMultiSelectClick = { },
                                modViewModel = viewModel
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = {
                        onConfirmRequest()
                    }) {
                        Text(stringResource(id = R.string.dialog_button_confirm))
                    }
                },
                dismissButton = {

                }
            )
        } else {
            onConfirmRequest()
        }
    }
}

// 使用 Glide 加载 Bitmap，同时保持图片比例
suspend fun loadImageBitmapFromPath(
    context: Context,
    path: String,
    reqWidth: Int,
    reqHeight: Int
): ImageBitmap? {
    return withContext(Dispatchers.IO) {
        try {
            val bitmap: Bitmap = Glide.with(context)
                .asBitmap()
                .load(path)
                .apply(RequestOptions().override(reqWidth, reqHeight))  // 指定最大宽度和高度，保持图片比例
                .submit()
                .get()
            bitmap.asImageBitmap()
        } catch (e: Exception) {
            Log.e("loadImageBitmapFromPath", "加载图片失败: $e")
            null
        }
    }
}

// 创建一个全屏的加载动画
@Composable
fun Loading(
    loadingPath: String = "loading"
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
        Text(
            text = stringResource(R.string.mod_pag_loading, loadingPath),
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.titleSmall
        )
    }
}


@Preview("Heroes List")
@Composable
fun HeroesPreview() {
    ModManagerTheme {
        Surface {
            Snackbar(
                action = {
                    Button(onClick = {}) {
                        Text("升级App")
                    }
                },
                containerColor = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "检测到有新版本") }
        }
    }
}
