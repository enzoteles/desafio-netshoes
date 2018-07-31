package br.com.netshoes.home

import android.arch.lifecycle.MutableLiveData
import br.com.netshoes.home.di.DaggerHomeComponent
import br.com.netshoes.home.di.HomeModule
import br.com.netshoes.webservice.allgists.ResponseAllGists
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomePresenter(val view: HomeMVP.View): HomeMVP.Presenter{

    @Inject
    lateinit var interactor: HomeMVP.Interactor

    override fun getAllGists(): MutableLiveData<List<ResponseAllGists>> {
        return interactor.getAllGists()
    }

    override fun initInteractor() {
        val homeComponent = DaggerHomeComponent.builder()
                .homeModule(HomeModule(view))
                .build()
        homeComponent.inject(this)
    }
}