package top.laoxin.modmanager.ui.view.components.mod

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.laoxin.modmanager.domain.bean.ModBean
import top.laoxin.modmanager.ui.viewmodel.ModDetailViewModel

@Composable
fun ModernModList(
    mods: List<ModBean>,
    modsSelected: Set<Int>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modSwitchEnable: Boolean,
    isMultiSelect: Boolean,
    isGridView: Boolean = false,
    showDialog: (ModBean) -> Unit,
    enableMod: (ModBean, Boolean) -> Unit,
    onLongClick: (ModBean) -> Unit,
    onMultiSelectClick: (ModBean) -> Unit,
    onUnlockClick: (ModBean) -> Unit,
    modDetailViewModel: ModDetailViewModel,
    listState: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    gridState: androidx.compose.foundation.lazy.grid.LazyGridState = androidx.compose.foundation.lazy.grid.rememberLazyGridState()
) {
    AnimatedContent(
        targetState = isGridView,
        transitionSpec = {
            fadeIn(androidx.compose.animation.core.tween(200))
                .togetherWith(
                    fadeOut(androidx.compose.animation.core.tween(200))
                )
        },
        label = "ModListViewModeTransition"
    ) { isGrid ->
        if (isGrid) {
            // 大图网格视图
            LazyVerticalGrid(
                state = gridState, // Use passed state
                columns = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = mods,
                    key = { mod -> mod.id },
                    contentType = { "modGridItem" }
                ) { mod ->
                    ModGridItem(
                        mod = mod,
                        isSelected = modsSelected.contains(mod.id),
                        onLongClick = onLongClick,
                        onMultiSelectClick = onMultiSelectClick,
                        isMultiSelect = isMultiSelect,
                        modSwitchEnable = modSwitchEnable,
                        openModDetail = { showDialog(mod) },
                        enableMod = enableMod,
                        onUnlockClick = onUnlockClick,
                        modDetailViewModel = modDetailViewModel
                    )
                }
            }
        } else {
            // 列表视图
            LazyColumn(
                state = listState, // Use passed state
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {
                items(
                    items = mods,
                    key = { mod -> mod.id },
                    contentType = { "modItem" }
                ) { mod ->
                    ModListItem(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        mod = mod,
                        isSelected = modsSelected.contains(mod.id),
                        onLongClick = onLongClick,
                        onMultiSelectClick = onMultiSelectClick,
                        isMultiSelect = isMultiSelect,
                        modSwitchEnable = modSwitchEnable,
                        openModDetail = { showDialog(mod) },
                        enableMod = enableMod,
                        onUnlockClick = onUnlockClick,
                        modDetailViewModel = modDetailViewModel
                    )
                }
            }
        }
    }
}
