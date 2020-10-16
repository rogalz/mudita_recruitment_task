package sh.surge.jakub.muditarecruitmenttask.data

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import sh.surge.jakub.muditarecruitmenttask.utils.typeconverters.TypeCurrencyConverter
import sh.surge.jakub.muditarecruitmenttask.utils.typeconverters.TypeStringListConverter

@Keep
@Entity(tableName = "countries")
@TypeConverters(TypeCurrencyConverter::class, TypeStringListConverter::class)
data class Country(
    @PrimaryKey
    val name: String,
    val currencies: List<Currency>,
    val callingCodes: List<String>,
    val topLevelDomain: List<String>
)