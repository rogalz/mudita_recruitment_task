package sh.surge.jakub.muditarecruitmenttask.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import sh.surge.jakub.muditarecruitmenttask.repo.MainRepository
import sh.surge.jakub.muditarecruitmenttask.repo.database.CountriesDatabase
import sh.surge.jakub.muditarecruitmenttask.repo.network.ApiService
import sh.surge.jakub.muditarecruitmenttask.repo.network.RetrofitInstance
import sh.surge.jakub.muditarecruitmenttask.utils.Const
import javax.inject.Singleton

@Module
class AppModule(var context: Context) {

    @Singleton
    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainRepo(database: CountriesDatabase, sharedPreferences: SharedPreferences, apiService: ApiService) = MainRepository(database, sharedPreferences, apiService)

    @Provides
    @Singleton
    fun providesDatabase(context: Context) = CountriesDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = context.getSharedPreferences(Const.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideApiService(): ApiService = RetrofitInstance.apiService
}