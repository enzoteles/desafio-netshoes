package br.com.netshoes

import android.arch.persistence.room.Database
import android.content.Context
import android.support.v7.widget.Toolbar
import br.com.netshoes.main.MainActivity
import br.com.netshoes.webservice.allgists.AppDataBase


/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

object Constant{

    var toolbar: Toolbar?= null
    val URL_DOMAIN = "https://api.github.com"
    var activity: MainActivity?= null
    var context: Context?= null
    var HTTP404 = "HTTP 404 Not Found"
    var NOADDRESS = "Unable to resolve host \"api.github.com\": No address associated with hostname"
    var tag_frag:String?= null
    var database: AppDataBase?= null

}