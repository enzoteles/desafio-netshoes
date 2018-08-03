package br.com.netshoes

import android.support.v4.app.FragmentActivity
import br.com.netshoes.home.HomeFragment
import org.junit.runner.RunWith
import org.junit.runners.model.InitializationError
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import android.R.attr.fragment
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.Constant.activity
import org.robolectric.shadows.support.v4.Shadows.shadowOf


/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

open class MyTestRunner(testClass: Class<*>?) : RobolectricTestRunner(testClass) {


    companion object {

        fun startFragment(homeFragment: HomeFragment){
            var manager = FragmentActivity().fragmentManager
            var transaction = manager.beginTransaction()
            transaction.add(homeFragment, null)
            transaction.commitAllowingStateLoss()

        }
    }



}