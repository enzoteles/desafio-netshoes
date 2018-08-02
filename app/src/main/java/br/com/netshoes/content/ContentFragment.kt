package br.com.netshoes.content

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.about.AboutMVP
import br.com.netshoes.content.di.ContentModule
import br.com.netshoes.content.di.DaggerContentComponent
import br.com.netshoes.favorites.FavoritesMVP
import br.com.netshoes.home.HomeMVP
import kotlinx.android.synthetic.main.content.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class ContentFragment : HelpFragment(), ContentMVP.View {

    @Inject
    lateinit var home: HomeMVP.View
    @Inject
    lateinit var favorites: FavoritesMVP.View
    @Inject
    lateinit var about: AboutMVP.View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.content, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initInjection()
        initView()
        Constant.toolbar = toolbar

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                HelpSecurity.manager!!.replaceFragment(R.id.options, home as HelpFragment, "home", false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                HelpSecurity.manager!!.replaceFragment(R.id.options, favorites as HelpFragment, "favorites", false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                HelpSecurity.manager!!.replaceFragment(R.id.options, about as HelpFragment , "about", false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun initInjection() {
        val contentComponent = DaggerContentComponent.builder()
                .contentModule(ContentModule())
                .build()
        contentComponent.inject(this)
    }

    override fun initView() {

        Handler().postDelayed({
            ll_splash.visibility = View.GONE
            ll_content.visibility = View.VISIBLE

        }, 2000)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        HelpSecurity.manager!!.addFragment(R.id.options, home as HelpFragment, "home", false)
        tb_im_upload.setOnClickListener {
            activity.finish()
        }
    }

}