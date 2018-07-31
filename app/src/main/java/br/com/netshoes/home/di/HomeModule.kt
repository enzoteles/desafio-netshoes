package br.com.netshoes.home.di

import br.com.netshoes.home.HomeInteractor
import br.com.netshoes.home.HomeMVP
import br.com.netshoes.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@Module
class HomeModule(var view: HomeMVP.View){

    @Provides
    fun provideHomePresenter(): HomeMVP.Presenter{
        return  HomePresenter(view)
    }

    @Provides
    fun provideHomeInteractor(): HomeMVP.Interactor{
        return HomeInteractor(HomePresenter(view))
    }
}