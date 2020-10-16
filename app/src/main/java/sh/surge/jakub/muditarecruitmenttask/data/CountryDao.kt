package sh.surge.jakub.muditarecruitmenttask.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(countries: List<Country>)

    @Query("SELECT * FROM countries")
    fun getAll(): LiveData<List<Country>>
}