package sh.surge.jakub.muditarecruitmenttask.splashfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import sh.surge.jakub.muditarecruitmenttask.R
import sh.surge.jakub.muditarecruitmenttask.di.DaggerAppComponent
import sh.surge.jakub.muditarecruitmenttask.di.modules.AppModule
import sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel.SplashVM
import javax.inject.Inject

class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var viewModel: SplashVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDagger()
    }

    private fun setupDagger() = DaggerAppComponent.builder().appModule(AppModule(requireContext())).build().inject(this)
}