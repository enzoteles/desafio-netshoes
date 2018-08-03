package br.com.netshoes.favorites

import br.com.netshoes.home.HomeMVP
import br.com.netshoes.home.HomePresenter
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@RunWith(MockitoJUnitRunner::class)
class FavoritesPresenterTest{


    @Mock
    lateinit var view: FavoritesMVP.View
    lateinit var presenter: FavoritesMVP.Presenter

    @Before
    fun setUp(){
        presenter = FavoritesPresenter(view)
    }

    @Test
    fun getAllGists(){
        assertNotNull(presenter)
    }

}