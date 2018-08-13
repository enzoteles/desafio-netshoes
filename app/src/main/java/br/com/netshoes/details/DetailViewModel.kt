package br.com.netshoes.details

import android.arch.lifecycle.ViewModel
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class DetailViewModel :ViewModel(){

    @Inject
    lateinit var interactor: DetailMVP.Interactor

    fun addGists(gistsPO: ResponseAllGistsPO) {
        interactor.addGist(gistsPO)
    }

    fun deleteGists(gistsPO: ResponseAllGistsPO) {
        interactor.deleteGists(gistsPO)
    }

    /*fun initInteractor() {
        val detailComponent = DaggerDetailComponent.builder()
                .detailModule(DetailModule(view))
                .build()
        detailComponent.inject(this)
    }*/

}