package br.com.netshoes.main.di

import br.com.netshoes.main.MainActivity
import dagger.Component

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Component(modules = arrayOf(MainModule::class))
interface MainComponent{
    fun inject(view: MainActivity)
}