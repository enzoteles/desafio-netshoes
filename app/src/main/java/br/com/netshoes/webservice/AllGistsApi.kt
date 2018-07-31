package br.com.netshoes.webservice

import br.com.netshoes.webservice.allgists.ResponseAllGists
import io.reactivex.Observable

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class AllGistsApi: BaseApi(){

    fun getAllGistsPublic(): Observable<List<ResponseAllGists>> {
        return services.getAllGistsPublic()
    }
}
