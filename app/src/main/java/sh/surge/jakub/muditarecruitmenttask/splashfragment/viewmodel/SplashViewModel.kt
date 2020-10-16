package sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ext.launchIO
import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.repo.MainRepository
import sh.surge.jakub.muditarecruitmenttask.utils.Result
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(), SplashVM {

    override val shouldDownloadData = repository.shouldDownloadData
    override val apiRequestState = MutableLiveData<Pair<Result<List<Country>>, Boolean>>()
    private val shouldSkipSplash = repository.appHasAnyData

    override fun downloadDataIfNeeded() {
        launchIO {
            when (val response = repository.downloadDataIfNeeded()) {
                is Result.Success -> {
                    val responseData = response.data
                    repository.insertCountries(responseData)
                    apiRequestState.postValue(Pair(response, shouldSkipSplash))
                }
                Result.EmptyResult -> Pair(response, shouldSkipSplash)
                is Result.NetworkException -> apiRequestState.postValue(Pair(response, shouldSkipSplash))
                is Result.HttpError -> apiRequestState.postValue(Pair(response, shouldSkipSplash))
            }
        }
    }

}