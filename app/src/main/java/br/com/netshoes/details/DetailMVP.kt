package br.com.netshoes.details

import br.com.netshoes.webservice.allgists.ResponseAllGistsPO

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
interface DetailMVP{
    interface View{
        fun initInjection()
        fun initView()
        fun initData()
    }
    interface Presenter {
        fun addGists(gistsPO: ResponseAllGistsPO)
        fun deleteGists(it: ResponseAllGistsPO)
        fun initInteractor()
    }

    interface Interactor {
        fun addGist(gistsPO: ResponseAllGistsPO)
        fun deleteGists(gistsPO: ResponseAllGistsPO)
    }
}