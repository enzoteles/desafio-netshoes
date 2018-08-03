package br.com.netshoes.favorites

import br.com.netshoes.Constant
import br.com.netshoes.home.HomeInteractor
import br.com.netshoes.home.HomeMVP
import br.com.netshoes.webservice.AllGistsApi
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@RunWith(MockitoJUnitRunner::class)
class FavoritesInteractorTest{

    @Mock
    lateinit var presenter: FavoritesMVP.Presenter
    lateinit var interactor: FavoritesMVP.Interactor

    @Before
    fun setUp(){
        interactor = FavoritesInteractor(presenter)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { h -> Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { h -> Schedulers.trampoline() }
    }

    @Test
    fun shouldshowloadAllListFavorites(){
        assertNotNull(interactor)
        val listAllGist = interactor.loadAllListFavorites()
        assertNotNull(listAllGist)

        val listFavorites = Constant.database!!.gistsDao().allGists()
        assertNotNull(listFavorites)

    }

}
