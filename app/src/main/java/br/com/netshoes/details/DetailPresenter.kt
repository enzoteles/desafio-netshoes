package br.com.netshoes.details

import br.com.netshoes.Constant
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class DetailPresenter(var view: DetailMVP.View): DetailMVP.Presenter{

    @Inject
    lateinit var interactor: DetailMVP.Interactor

    override fun addGists(gistsPO: ResponseAllGistsPO) {
        interactor.addGist(gistsPO)
    }

    override fun deleteGists(gistsPO: ResponseAllGistsPO) {
        interactor.deleteGists(gistsPO)
    }

    override fun initInteractor() {
        val detailComponent = DaggerDetailComponent.builder()
                .detailModule(DetailModule(view))
                .build()
        detailComponent.inject(this)
    }

}