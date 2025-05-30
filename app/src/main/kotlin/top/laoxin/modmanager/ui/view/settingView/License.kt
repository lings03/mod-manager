package top.laoxin.modmanager.ui.view.settingView

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.ui.compose.LibraryDefaults
import com.mikepenz.aboutlibraries.ui.compose.m3.LibrariesContainer
import com.mikepenz.aboutlibraries.ui.compose.m3.libraryColors
import com.mikepenz.aboutlibraries.util.withJson
import top.laoxin.modmanager.R
import top.laoxin.modmanager.ui.viewmodel.SettingViewModel

@Composable
fun License(modifier: Modifier, viewModel: SettingViewModel) {
    val context = LocalContext.current

    LibrariesContainer(
        modifier = modifier,
        librariesBlock = { ctx ->
            Libs.Builder()
                .withJson(ctx, R.raw.aboutlibraries)
                .build()
        },
        colors = LibraryDefaults.libraryColors(
            badgeBackgroundColor = MaterialTheme.colorScheme.tertiary
        ),
        padding = LibraryDefaults.libraryPadding(
            badgeContentPadding = PaddingValues(4.dp)
        ),
        onLibraryClick = { library ->
            library.website?.let { website ->
                viewModel.openUrl(context, website)
            }
        },
    )

    BackHandler {
        viewModel.setAboutPage(false)
    }
}
