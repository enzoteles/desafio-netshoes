package br.com.netshoes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.content.ContentFragment

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class MainActivity : AppCompatActivity() {
    lateinit var content: ContentFragment
    lateinit var manager: HelpManagerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = HelpManagerFragment(this)
        HelpSecurity.manager = manager
        content = ContentFragment()
        manager!!.addFragment(R.id.content, content, "content", false)

    }

}
