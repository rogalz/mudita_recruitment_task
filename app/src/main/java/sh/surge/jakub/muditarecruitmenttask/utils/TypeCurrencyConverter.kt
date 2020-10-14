package sh.surge.jakub.muditarecruitmenttask.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import sh.surge.jakub.muditarecruitmenttask.data.Currency

class TypeCurrencyConverter {

    @TypeConverter
    internal fun fromListToDb(optionValues: List<Currency>?): String? {
        if (optionValues == null) {
            return null
        }
        val type = object : TypeToken<List<Currency>>() {}.type
        return Gson().toJson(optionValues, type)
    }

    @TypeConverter
    internal fun fromDbToList(optionValuesString: String?): List<Currency>? {
        if (optionValuesString == null) {
            return null
        }
        val type = object : TypeToken<List<Currency>>() {}.type
        return Gson().fromJson<List<Currency>>(optionValuesString, type)
    }
}