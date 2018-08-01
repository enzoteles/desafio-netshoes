package br.com.netshoes.details

import br.com.netshoes.content.ContentFragment
import br.com.netshoes.home.HomeFragment
import br.com.netshoes.home.HomePresenter
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