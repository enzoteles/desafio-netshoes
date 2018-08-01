package br.com.netshoes.webservice.allgists

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Database(entities = [ResponseAllGistsPO::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase(){
    abstract fun gistsDao(): GistsDao

}