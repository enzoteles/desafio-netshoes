package br.com.netshoes.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.R
import br.com.netshoes.content.ContentMVP
import br.com.netshoes.main.di.DaggerMainComponent
import br.com.netshoes.main.di.MainModule
import javax.inject.Inject

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

        initInjection()
        initView()

    }

    fun initInjection() {
        val mainComponent = DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .build()
        mainComponent.inject(this)
    }

    fun initView(){
        HelpSecurity.manager = manager
        manager!!.addFragment(R.id.content, content as HelpFragment, "content", false)
    }
}
