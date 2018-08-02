package br.com.netshoes.details.di

import br.com.netshoes.details.DetailFragment
import br.com.netshoes.details.DetailPresenter
import dagger.Component

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Component(modules = arrayOf(DetailModule::class))
interface DetailComponent{
    fun inject(view: DetailFragment)
    fun inject(presenter: DetailPresenter)
}