package br.com.netshoes.webservice

import br.com.netshoes.webservice.allgists.ResponseAllGists
import br.com.netshoes.webservice.gists.ResponseGists
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface ApiRest{

    @GET("/gists/public")
    fun getAllGistsPublic(): Observable<List<ResponseAllGists>>

    @GET("/gists/{id}")
    fun getGists(@Query("id") id: String): Observable<ResponseGists>
}