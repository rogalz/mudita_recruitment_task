package sh.surge.jakub.muditarecruitmenttask.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeStringListConverter {

    @TypeConverter
    internal fun fromListToDb(optionValues: List<String>?): String? {
        if (optionValues == null) {
            return null
        }
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().toJson(optionValues, type)
    }

    @TypeConverter
    internal fun fromDbToList(optionValuesString: String?): List<String>? {
        if (optionValuesString == null) {
            return null
        }
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson<List<String>>(optionValuesString, type)
    }
}