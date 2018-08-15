package br.com.netshoes.favorites

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class FavoritesViewModel: ViewModel(){

    var repository: FavoritesRepository = FavoritesRepository()

    fun loadAllListFavorites(): MutableLiveData<List<ResponseAllGistsPO>> {
        return repository.loadAllListFavorites()
    }

    /*fun initInteractor() {
        val favoritesComponent = DaggerFavoritesComponent.builder()
                .favoritesModule(FavoritesModule(view))
                .build()
        favoritesComponent.inject(this)
    }*/

}