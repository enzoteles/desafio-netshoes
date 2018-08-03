package br.com.netshoes.main

import android.support.v7.app.AppCompatActivity
import br.com.netshoes.BuildConfig
import br.com.netshoes.content.ContentFragment
import br.com.netshoes.content.ContentMVP
import junit.framework.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.util.FragmentTestUtil

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21), manifest = "AndroidManifest.xml")
class MainActivityTest{

    lateinit var contentFragment: ContentFragment
    lateinit var activity: MainActivity
    @Before
    fun setUp() {
        activity = Robolectric.setupActivity(MainActivity::class.java)
        contentFragment = ContentFragment()
    }

    @Test
    fun initUILogin(){
        FragmentTestUtil.startFragment(contentFragment , AppCompatActivity::class.java)
        Assert.assertNotNull(contentFragment)
    }
}