package sh.surge.jakub.muditarecruitmenttask.repo

import android.content.SharedPreferences
import sh.surge.jakub.muditarecruitmenttask.repo.database.CountriesDatabase
import sh.surge.jakub.muditarecruitmenttask.repo.network.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private var database: CountriesDatabase,
    private var sharedPreferences: SharedPreferences,
    private var apiService: ApiService
) {

}


