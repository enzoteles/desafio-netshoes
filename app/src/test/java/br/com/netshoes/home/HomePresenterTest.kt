package br.com.netshoes.home

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
class HomePresenterTest{

    @Mock
    lateinit var view: HomeMVP.View
    lateinit var presenter: HomeMVP.Presenter

    @Before
    fun setUp(){
        presenter = HomeViewModel(view)
    }

    @Test
    fun getAllGists(){
        assertNotNull(presenter)
    }

}



