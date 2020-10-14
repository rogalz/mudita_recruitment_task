package sh.surge.jakub.muditarecruitmenttask

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.data.CountryDao

@Database(entities = [Country::class], version = 1)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun currencyDao(): CountryDao

    companion object {
        @Volatile
        private var INSTANCE: CountriesDatabase? = null

        fun getDatabase(context: Context): CountriesDatabase {
            INSTANCE = init(context)
            return INSTANCE as CountriesDatabase
        }

        private fun init(context: Context): CountriesDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                CountriesDatabase::class.java,
                "Database"
            ).build()
    }
}