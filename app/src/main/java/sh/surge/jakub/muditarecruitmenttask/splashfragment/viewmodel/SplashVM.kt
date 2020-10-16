package sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.utils.Result

interface SplashVM {
    val shouldDownloadData: Boolean
    val apiRequestState: MutableLiveData<Pair<Result<List<Country>>, Boolean>>

    fun downloadDataIfNeeded()
}