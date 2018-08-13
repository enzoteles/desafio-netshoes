package br.com.netshoes.favorites

import android.arch.lifecycle.MutableLiveData
import br.com.netshoes.favorites.di.DaggerFavoritesComponent
import br.com.netshoes.favorites.di.FavoritesModule
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class FavoritesPresenter(var view: FavoritesMVP.View): FavoritesMVP.Presenter{

    @Inject
    lateinit var interactor: FavoritesMVP.Interactor

    override fun loadAllListFavorites(): MutableLiveData<List<ResponseAllGistsPO>> {
        return interactor.loadAllListFavorites()
    }

    override fun initInteractor() {
        val favoritesComponent = DaggerFavoritesComponent.builder()
                .favoritesModule(FavoritesModule(view))
                .build()
        favoritesComponent.inject(this)
    }

}