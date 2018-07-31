package br.com.netshoes.webservice

import br.com.netshoes.webservice.allgists.ResponseAllGists
import br.com.netshoes.webservice.gists.ResponseGists
import io.reactivex.Observable

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class GistsApi: BaseApi(){
    fun getCellsList(id: String): Observable<ResponseGists> {
        return services.getGists(id)
    }
}
