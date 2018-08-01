package br.com.netshoes.home

import android.arch.lifecycle.MutableLiveData
import br.com.netshoes.webservice.allgists.ResponseAllGists

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
interface HomeMVP{

    interface View {
        fun initView()
        fun initData()
        fun initInjection()
    }

    interface Presenter{
        fun getAllGists(): MutableLiveData<List<ResponseAllGists>>
        fun initInteractor()
        fun error(message: String?)
    }
    interface Interactor{
        fun getAllGists() : MutableLiveData<List<ResponseAllGists>>
    }
}