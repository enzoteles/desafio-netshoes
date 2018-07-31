package br.com.netshoes.home

import android.arch.lifecycle.MutableLiveData
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.netshoes.webservice.AllGistsApi
import br.com.netshoes.webservice.allgists.ResponseAllGists
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.security.auth.callback.Callback

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeInteractor(val callback: HomeMVP.Presenter): HomeMVP.Interactor{

    override fun getAllGists() : MutableLiveData<List<ResponseAllGists>> {
        var data: MutableLiveData<List<ResponseAllGists>>?=  MutableLiveData<List<ResponseAllGists>>()
        val api = AllGistsApi()
        api.getAllGistsPublic()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ response ->
                    data?.value = response
                }, { e ->
                    HelpLog.error("${e.message}")
                })
        return data!!
    }


}