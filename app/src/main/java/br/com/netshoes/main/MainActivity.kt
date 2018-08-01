package br.com.netshoes.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.content.ContentMVP
import br.com.netshoes.main.di.DaggerMainComponent
import br.com.netshoes.main.di.MainModule
import javax.inject.Inject
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.security.ProviderInstaller
import android.app.Activity
import android.arch.persistence.room.Room
import android.util.Log
import br.com.netshoes.webservice.allgists.AppDataBase


/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var content: ContentMVP.View
    @Inject
    lateinit var manager: HelpManagerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Constant.tag_frag = null
        updateAndroidSecurityProvider(this)
        initInjection()
        initView()
        initData()

    }

    fun initInjection() {
        val mainComponent = DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .build()
        mainComponent.inject(this)
    }

    fun initView(){
        Constant.activity = this
        Constant.context = baseContext

        HelpSecurity.manager = manager
        manager!!.addFragment(R.id.content, content as HelpFragment, "content", false)
    }

    fun initData() {

        Constant.database = Room.databaseBuilder(
                this,
                AppDataBase::class.java,
                "netshoes-database")
                .allowMainThreadQueries()
                .build()
    }

    fun updateAndroidSecurityProvider(callingActivity: Activity) {
        try {
            ProviderInstaller.installIfNeeded(this)
        } catch (e: GooglePlayServicesRepairableException) {
            // Thrown when Google Play Services is not installed, up-to-date, or enabled
            // Show dialog to allow users to install, update, or otherwise enable Google Play services.
            GooglePlayServicesUtil.getErrorDialog(e.connectionStatusCode, callingActivity, 0)
        } catch (e: GooglePlayServicesNotAvailableException) {
            Log.e("SecurityException", "Google Play Services not available.")
        }

    }

    override fun onBackPressed() {

        if(Constant.tag_frag.equals("DETAIL")){
            super.onBackPressed()
        }
        //super.onBackPressed()
    }
}
