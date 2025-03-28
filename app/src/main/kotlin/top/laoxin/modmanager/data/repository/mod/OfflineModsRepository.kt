package top.laoxin.modmanager.data.repository.mod

import kotlinx.coroutines.flow.Flow
import top.laoxin.modmanager.data.bean.ModBean
import top.laoxin.modmanager.data.repository.ModManagerDatabase
import javax.inject.Inject

class OfflineModsRepository @Inject constructor(private val database: ModManagerDatabase) :
    ModRepository {
    private val modDao = database.modDao()
    override fun getAllIModsStream(): Flow<List<ModBean>> {
        return modDao.getAll()
    }

    override fun search(name: String, gamePackageName: String): Flow<List<ModBean>> {
        return modDao.getModsByGamePackageNameAndName(gamePackageName, name)
    }


    override suspend fun insertMod(mod: ModBean) {
        modDao.insert(mod)
    }

    override suspend fun deleteMod(mod: ModBean) {
        modDao.delete(mod)
    }

    override suspend fun updateMod(mod: ModBean) {
        modDao.update(mod)
    }

    override suspend fun getModById(id: Int): ModBean {
        return modDao.getModById(id)
    }


    override suspend fun insertAll(mods: List<ModBean>) {
        modDao.insertAll(mods)
    }

    override fun getDisableMods(gamePackageName: String): Flow<List<ModBean>> {
        return modDao.getDisableModsByGamePackageName(gamePackageName)
    }

    override suspend fun deleteAll(mods: List<ModBean>) {
        modDao.deleteMods(mods)
    }


    override suspend fun updateAll(mods: List<ModBean>) {
        modDao.updateMods(mods)
    }

    override fun getModsByGamePackageName(gamePackageName: String): Flow<List<ModBean>> {
        return modDao.getModsByGamePackageName(gamePackageName)
    }

    override fun getModsCountByGamePackageName(gamePackageName: String): Flow<Int> {
        return modDao.getModsCountByGamePackageName(gamePackageName)
    }

    override fun getEnableMods(gamePackageName: String): Flow<List<ModBean>> {
        return modDao.getEnableModsByGamePackageName(gamePackageName)
    }


    override fun getModsByPathAndGamePackageName(
        path: String,
        gamePackageName: String
    ): Flow<List<ModBean>> {
        return modDao.getModsByPathAndGamePackageName(path, gamePackageName)
    }

    override fun getEnableModsCountByGamePackageName(gamePackageName: String): Flow<Int> {
        return modDao.getModsEnableCountByGamePackageName(gamePackageName)
    }

    override fun getModsByIds(ids: List<Int>): Flow<List<ModBean>> {
        return modDao.getModsByIds(ids)
    }

    override fun getModsCountByPath(path: String): Flow<Int> {
        return modDao.getModsCountByPath(path)
    }

    override fun getModsByPath(path: String): Flow<List<ModBean>> {
        return modDao.getModsByPath(path)
    }

    override fun deleteDisableMods(gamePackageName: String) {
        modDao.deleteDisableMods(gamePackageName)
    }

}