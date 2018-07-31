package br.com.netshoes.content.di

import br.com.netshoes.content.ContentFragment
import dagger.Component

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Component(modules = arrayOf(ContentModule::class))
interface ContentComponent{
    fun inject(view: ContentFragment)
}