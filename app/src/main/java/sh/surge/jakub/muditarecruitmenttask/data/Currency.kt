package sh.surge.jakub.muditarecruitmenttask.data

import androidx.annotation.Keep

@Keep
data class Currency(
    val name: String,
    val code: String,
    val symbol: String
)