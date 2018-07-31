package br.com.netshoes.content

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.R
import br.com.netshoes.about.AboutFragment
import br.com.netshoes.favorites.FavoritesFragment
import br.com.netshoes.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content.*

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class ContentFragment : HelpFragment() {

    lateinit var home: HomeFragment
    lateinit var favorites: FavoritesFragment
    lateinit var about: AboutFragment

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.content, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        home = HomeFragment()
        favorites = FavoritesFragment()
        about = AboutFragment()
        HelpSecurity.manager!!.addFragment(R.id.options, home, "home", false)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                HelpSecurity.manager!!.replaceFragment(R.id.options, home, "home", false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                HelpSecurity.manager!!.replaceFragment(R.id.options, favorites, "favorites", false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                HelpSecurity.manager!!.replaceFragment(R.id.options, about  , "about", false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}