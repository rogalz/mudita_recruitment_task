package sh.surge.jakub.muditarecruitmenttask.di.modules

import dagger.Module
import dagger.Provides
import sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.viewmodel.ListVM
import sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.viewmodel.ListViewModel
import sh.surge.jakub.muditarecruitmenttask.repo.MainRepository
import sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel.SplashVM
import sh.surge.jakub.muditarecruitmenttask.splashfragment.viewmodel.SplashViewModel
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideSplashViewModel(repository: MainRepository): SplashVM = SplashViewModel(repository)

    @Provides
    @Singleton
    fun provideListViewModel(repository: MainRepository): ListVM = ListViewModel(repository)
}