package br.com.netshoes.home

import br.com.netshoes.home.di.DaggerHomeComponent
import br.com.netshoes.home.di.HomeModule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@RunWith(MockitoJUnitRunner::class)
class HomePresenterTest{

    @Mock
    lateinit var view: HomeMVP.View
    lateinit var presenter: HomeMVP.Presenter

    @Before
    fun setUp(){
        presenter = HomePresenter(view)
    }

    @Test
    fun getAllGists(){
        assertNotNull(presenter)
    }

}



