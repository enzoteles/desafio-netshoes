package br.com.netshoes.favorites

import android.arch.lifecycle.MutableLiveData
import br.com.netshoes.webservice.allgists.ResponseAllGists
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface FavoritesMVP{
    interface View {
        fun initInjection()
        fun initView()
        fun initData()
        fun setrecyclerview(listGists: List<ResponseAllGistsPO>?)
    }

    interface Presenter {
        fun loadAllListFavorites(): MutableLiveData<List<ResponseAllGistsPO>>
        fun initInteractor()
    }

    interface Interactor {
        fun loadAllListFavorites(): MutableLiveData<List<ResponseAllGistsPO>>
    }
}