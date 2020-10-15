package sh.surge.jakub.muditarecruitmenttask.repo.network

import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.utils.Result
import java.io.IOException
import javax.inject.Inject

class ApiCallWrapper @Inject constructor(private var apiService: ApiService) {

    suspend fun getCountriesWithSealed(): Result<List<Country>> {
        return try {
            val response = apiService.getCountries()
            if (response.isSuccessful) {
                if (response != null) {
                    Result.Success(response.body()!!)
                } else {
                    Result.EmptyResult
                }
            } else
                Result.HttpError(response.code(), response.message())


        } catch (error: IOException) {
            Result.NetworkException(error.message!!)
        }
    }
}