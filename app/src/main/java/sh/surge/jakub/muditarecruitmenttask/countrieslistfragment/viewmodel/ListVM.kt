package sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.viewmodel

import androidx.lifecycle.LiveData
import sh.surge.jakub.muditarecruitmenttask.data.Country

interface ListVM {
    val allCountries: LiveData<List<Country>>
}
