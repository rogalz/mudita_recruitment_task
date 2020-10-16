package sh.surge.jakub.muditarecruitmenttask.di

import dagger.Component
import sh.surge.jakub.muditarecruitmenttask.countrieslistfragment.ListFragment
import sh.surge.jakub.muditarecruitmenttask.di.modules.AppModule
import sh.surge.jakub.muditarecruitmenttask.di.modules.ViewModelModule
import sh.surge.jakub.muditarecruitmenttask.splashfragment.SplashFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: SplashFragment)
    fun inject(fragment: ListFragment)
}