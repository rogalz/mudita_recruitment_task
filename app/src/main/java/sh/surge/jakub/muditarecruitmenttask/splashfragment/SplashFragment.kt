package sh.surge.jakub.muditarecruitmenttask.splashfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ext.showToast
import sh.surge.jakub.muditarecruitmenttask.R
import sh.surge.jakub.muditarecruitmenttask.activity.MainActivity
import sh.surge.jakub.muditarecruitmenttask.di.DaggerAppComponent
import sh.surge.jakub.muditarecruitmenttask.di.modules.AppModule
import sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel.SplashVM
import sh.surge.jakub.muditarecruitmenttask.utils.Result
import javax.inject.Inject

class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var viewModel: SplashVM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDagger()
        downloadDataIfNeeded()
        observeApiRequestState()
    }

    private fun setupDagger() = DaggerAppComponent.builder().appModule(AppModule(requireContext())).build().inject(this)

    private fun downloadDataIfNeeded() {
        if (viewModel.shouldDownloadData)
            viewModel.downloadDataIfNeeded()
        else
            closeSplash()
    }

    private fun closeSplash() = activity?.let { (it as MainActivity).closeSplash() }

    private fun observeApiRequestState() {
        viewModel.apiRequestState.observe(viewLifecycleOwner, {
            val result = it.first
            val shouldSkipSplash = it.second
            when (result) {
                is Result.Success -> closeSplash()
                Result.EmptyResult -> skipSplashIfNeeded(shouldSkipSplash) { showToast(R.string.somethingWentWrong) }
                is Result.NetworkException -> skipSplashIfNeeded(shouldSkipSplash) { showToast(R.string.connectionError) }
                is Result.HttpError -> skipSplashIfNeeded(shouldSkipSplash) { showToast(R.string.httpErrorOccurred + result.errorCode) }
            }
        })
    }

    private fun skipSplashIfNeeded(shouldSkipSplash: Boolean, showToast: () -> Unit) {
        if (shouldSkipSplash)
            closeSplash()
        else
            showToast.invoke()
    }
}