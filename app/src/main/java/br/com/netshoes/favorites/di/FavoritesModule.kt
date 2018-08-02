package br.com.netshoes.favorites.di

import br.com.netshoes.details.DetailInteractor
import br.com.netshoes.details.DetailMVP
import br.com.netshoes.details.DetailPresenter
import br.com.netshoes.favorites.FavoritesInteractor
import br.com.netshoes.favorites.FavoritesMVP
import br.com.netshoes.favorites.FavoritesPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@Module
class FavoritesModule(var view: FavoritesMVP.View){

    @Provides
    fun provideFavoritesPresenter(): FavoritesMVP.Presenter{
        return FavoritesPresenter(view)
    }

    @Provides
    fun provideFavoritesInteractor(): FavoritesMVP.Interactor{
        return FavoritesInteractor(FavoritesPresenter(view))
    }

}