package sh.surge.jakub.muditarecruitmenttask.repo.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sh.surge.jakub.muditarecruitmenttask.data.Country

interface ApiService {

    @GET("all")
    suspend fun getCountries(@Query("fields") value: String = "name;currencies;callingCodes;topLevelDomain;flag"): Response<List<Country>>
}
