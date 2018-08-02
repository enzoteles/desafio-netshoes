package br.com.netshoes.favorites

import android.arch.lifecycle.MutableLiveData
import br.com.netshoes.Constant
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class FavoritesInteractor(var callback: FavoritesMVP.Presenter) : FavoritesMVP.Interactor {

    override fun loadAllListFavorites(): MutableLiveData<List<ResponseAllGistsPO>> {
        val gists: MutableLiveData<List<ResponseAllGistsPO>> = MutableLiveData<List<ResponseAllGistsPO>>()
        gists?.value = Constant.database!!.gistsDao().allGists()
        return gists
    }


}