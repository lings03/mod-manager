package top.laoxin.modmanager.database

import android.content.Context
import top.laoxin.modmanager.database.antiHarmony.AntiHarmonyRepository
import top.laoxin.modmanager.database.antiHarmony.OfflineAntiHarmonyRepository
import top.laoxin.modmanager.database.backups.BackupRepository
import top.laoxin.modmanager.database.backups.OfflineBackupRepository
import top.laoxin.modmanager.database.mods.ModRepository
import top.laoxin.modmanager.database.mods.OfflineModsRepository
import top.laoxin.modmanager.database.sacnFile.OfflineScanFileRepository
import top.laoxin.modmanager.database.sacnFile.ScanFileRepository

interface AppContainer {
    val modRepository: ModRepository
    val backupRepository: BackupRepository
    val antiHarmonyRepository: AntiHarmonyRepository
    val scanFileRepository: ScanFileRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val modRepository: ModRepository by lazy {
        OfflineModsRepository(ModManagerDatabase.getDatabase(context).modDao())

    }

    override val backupRepository: BackupRepository by lazy {
        OfflineBackupRepository(ModManagerDatabase.getDatabase(context).backupDao())
    }

    override val antiHarmonyRepository: AntiHarmonyRepository by lazy {
        OfflineAntiHarmonyRepository(ModManagerDatabase.getDatabase(context).antiHarmonyDao())
    }

    override val scanFileRepository: ScanFileRepository by lazy {
        OfflineScanFileRepository(ModManagerDatabase.getDatabase(context).scanFileDao())
    }

}