package br.com.netshoes.details.di

import br.com.netshoes.details.DetailRepository
import br.com.netshoes.details.DetailMVP
import br.com.netshoes.details.DetailViewModel
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
class DetailModule(var view: DetailMVP.View){

    @Provides
    fun provideDetailPresenter(): DetailMVP.Presenter{
        return DetailViewModel(view)
    }

    @Provides
    fun provideDetailInteractor(): DetailMVP.Interactor{
        return DetailRepository(DetailViewModel(view))
    }

}*/
