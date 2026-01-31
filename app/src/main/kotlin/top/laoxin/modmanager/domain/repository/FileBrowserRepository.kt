package top.laoxin.modmanager.domain.repository

import top.laoxin.modmanager.domain.model.Result
import java.io.File

interface FileBrowserRepository {
    /**
     * Get files for a specific path.
     * Supports standard directories and ZIP archives.
     */
    suspend fun getFiles(path: String, searchQuery: String? = null): Result<List<File>>
}
