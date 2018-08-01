package br.com.netshoes.details

import br.com.netshoes.Constant
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class DetailInteractor(var callback: DetailMVP.Presenter) : DetailMVP.Interactor {
    override fun addGist(gistsPO: ResponseAllGistsPO) {
        Constant.database!!.gistsDao().addGists(gistsPO)
    }

    override fun deleteGists(gistsPO: ResponseAllGistsPO) {
        Constant.database!!.gistsDao().deleteGists(gistsPO)
    }


}
