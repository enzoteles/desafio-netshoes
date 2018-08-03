package br.com.netshoes.home

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import br.com.netshoes.BuildConfig
import br.com.netshoes.MyTestRunner
import br.com.netshoes.R
import br.com.netshoes.main.MainActivity
import com.wang.avi.AVLoadingIndicatorView
import kotlinx.android.synthetic.main.toolbar.view.*
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@RunWith(MyTestRunner::class)
@Config(constants= BuildConfig::class, sdk = intArrayOf(21), manifest = "AndroidManifest.xml")
class HomeFragmentTest{

    lateinit var activity: MainActivity
    lateinit var toolbar: Toolbar
    lateinit var avi: AVLoadingIndicatorView
    lateinit var recyclerView: RecyclerView
    lateinit var home: HomeFragment

    @Before
    fun setUp(){

        home = HomeFragment()
        MyTestRunner.startFragment(home)
        assertNotNull(home)

        val view:View = home.view

        avi = view.findViewById(R.id.avi)
        recyclerView = view.findViewById(R.id.hm_rv_gists)
        toolbar = view.findViewById(R.id.toolbar)

    }



    @Test
    fun shouldShowTitleToolbar(){
        assertEquals(toolbar.ct_tb_tv_title.text.toString(), activity.resources.getString(R.string.title_home))
    }

    @Test
    fun shouldShowAvi(){

        assertThat(avi.visibility, `is`(View.VISIBLE))
        assertThat(recyclerView.visibility, `is`(View.INVISIBLE))

       assertThat(avi.visibility, `is`(View.INVISIBLE))
       assertThat(recyclerView.visibility, `is`(View.VISIBLE))

    }





}