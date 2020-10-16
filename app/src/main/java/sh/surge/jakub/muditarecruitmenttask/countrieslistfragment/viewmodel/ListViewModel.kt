package sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.repo.MainRepository
import javax.inject.Inject

class ListViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(), ListVM {
    override val allCountries: LiveData<List<Country>> = repository.allCountries

}