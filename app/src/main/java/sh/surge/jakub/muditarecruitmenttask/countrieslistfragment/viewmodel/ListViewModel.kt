package sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.viewmodel

import androidx.lifecycle.ViewModel
import sh.surge.jakub.muditarecruitmenttask.repo.MainRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(), ListVM {

}