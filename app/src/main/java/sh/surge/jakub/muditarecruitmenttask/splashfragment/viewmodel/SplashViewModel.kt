package sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel

import androidx.lifecycle.ViewModel
import sh.surge.jakub.muditarecruitmenttask.repo.MainRepository
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(), SplashVM {

}