package br.com.netshoes.webservice.allgists

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Dao
interface GistsDao{

    @Query("SELECT * FROM responseAllGistsPO")
    fun allGists(): List<ResponseAllGistsPO>

    @Insert
    fun addGists(vararg gists: ResponseAllGistsPO)

    @Delete
    fun deleteGists(vararg gists: ResponseAllGistsPO)
}