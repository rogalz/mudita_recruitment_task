package sh.surge.jakub.muditarecruitmenttask.repo

import android.content.SharedPreferences
import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.repo.database.CountriesDatabase
import sh.surge.jakub.muditarecruitmenttask.repo.network.ApiCallWrapper
import sh.surge.jakub.muditarecruitmenttask.utils.Const
import sh.surge.jakub.muditarecruitmenttask.utils.Result
import javax.inject.Inject

class MainRepository @Inject constructor(
    private var database: CountriesDatabase,
    private var sharedPreferences: SharedPreferences,
    private var apiCallWrapper: ApiCallWrapper
) {

    private val currentTime = System.currentTimeMillis()

    val shouldDownloadData: Boolean
        get() = shouldUpdate(currentTime)
    val appHasAnyData: Boolean
        get() = sharedPreferences.getBoolean(Const.SHARED_PREFERENCES_KEY_FIRST_HAS_ANY_DATA, false)

    suspend fun downloadDataIfNeeded(): Result<List<Country>> = apiCallWrapper.getCountriesWithSealed()

    private fun shouldUpdate(currentTime: Long): Boolean {
        val lastUpdateTime = sharedPreferences.getLong(Const.SHARED_PREFERENCES_KEY_LAST_UPDATE, 0)
        val nextUpdateTime = lastUpdateTime + Const.MILLIS_24h

        return nextUpdateTime < currentTime || !appHasAnyData
    }

    private fun updateSharedPref(currentTime: Long) {
        sharedPreferences.edit().putLong(Const.SHARED_PREFERENCES_KEY_LAST_UPDATE, currentTime).apply()
        sharedPreferences.edit().putBoolean(Const.SHARED_PREFERENCES_KEY_FIRST_HAS_ANY_DATA, true).apply()
    }

    fun insertCountries(data: List<Country>) {
        updateSharedPref(currentTime)
        database.currencyDao().insertAll(data)
    }
}