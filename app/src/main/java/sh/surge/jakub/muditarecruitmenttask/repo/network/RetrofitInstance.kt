package sh.surge.jakub.muditarecruitmenttask.repo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sh.surge.jakub.muditarecruitmenttask.utils.Const

object RetrofitInstance {
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}