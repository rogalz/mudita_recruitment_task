package sh.surge.jakub.muditarecruitmenttask.countrieslistfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import sh.surge.jakub.muditarecruitmenttask.R
import sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.viewmodel.ListVM
import sh.surge.jakub.muditarecruitmenttask.di.DaggerAppComponent
import sh.surge.jakub.muditarecruitmenttask.di.modules.AppModule
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list) {

    @Inject
    lateinit var viewModel: ListVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDagger()
    }

    private fun setupDagger() = DaggerAppComponent.builder().appModule(AppModule(requireContext())).build().inject(this)
}