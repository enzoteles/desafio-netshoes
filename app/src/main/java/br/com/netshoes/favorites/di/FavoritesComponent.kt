package br.com.netshoes.favorites.di

import br.com.netshoes.favorites.FavoritesFragment
import br.com.netshoes.favorites.FavoritesPresenter
import dagger.Component

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Component(modules = arrayOf(FavoritesModule::class))
interface FavoritesComponent{
    fun inject(view: FavoritesFragment)
    fun inject(presenter: FavoritesPresenter)
}