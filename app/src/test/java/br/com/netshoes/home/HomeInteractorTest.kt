package br.com.netshoes.home

import br.com.netshoes.webservice.AllGistsApi
import br.com.netshoes.webservice.allgists.ResponseAllGists
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner
import io.reactivex.schedulers.Schedulers
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers


/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@RunWith(MockitoJUnitRunner::class)
class HomeInteractorTest{

    @Mock
    lateinit var presenter: HomeMVP.Presenter
    lateinit var interactor: HomeMVP.Interactor

    @Before
    fun setUp(){
        interactor = HomeInteractor(presenter)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { h -> Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { h -> Schedulers.trampoline() }
    }

    @Test
    fun shouldshowAllGists(){
        assertNotNull(interactor)
        val listAllGist = interactor.getAllGists()
        assertNotNull(listAllGist)

        val api = AllGistsApi()
        api.getAllGistsPublic()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe ({ response ->
                    setListAllGist(response)
                })

    }

    fun setListAllGist(response: List<ResponseAllGists>) {

        val listGists: MutableList<ResponseAllGists> = ArrayList()

        response.forEach {
            it-> listGists.add(it)
        }
        assertEquals(listGists[0].owner!!.login, "Enzo")
    }

}