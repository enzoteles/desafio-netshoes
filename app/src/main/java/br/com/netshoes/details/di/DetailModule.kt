package br.com.netshoes.details.di

import br.com.netshoes.details.DetailInteractor
import br.com.netshoes.details.DetailMVP
import br.com.netshoes.details.DetailPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@Module
class DetailModule(var view: DetailMVP.View){

    @Provides
    fun provideDetailPresenter(): DetailMVP.Presenter{
        return DetailPresenter(view)
    }

    @Provides
    fun provideDetailInteractor(): DetailMVP.Interactor{
        return DetailInteractor(DetailPresenter(view))
    }

}