package br.com.netshoes.home.di

import br.com.netshoes.details.DetailFragment
import br.com.netshoes.details.DetailMVP
import br.com.netshoes.home.HomeRepository
import br.com.netshoes.home.HomeMVP
import br.com.netshoes.home.HomeViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

/*
@Module
class HomeModule(var view: HomeMVP.View){

    @Provides
    fun provideHomePresenter(): HomeMVP.Presenter{
        return  HomeViewModel(view)
    }

    @Provides
    fun provideHomeInteractor(): HomeMVP.Interactor{
        return HomeRepository(HomeViewModel(view))
    }

    @Provides
    fun provideDetailFragment(): DetailMVP.View{
        return DetailFragment()
    }


}*/
