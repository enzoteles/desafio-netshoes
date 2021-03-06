package br.com.netshoes.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.netshoes.Constant
import br.com.netshoes.R
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class AboutFragment: HelpFragment(), AboutMVP.View{

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.about, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Constant.toolbar!!.ct_tb_tv_title.setText("About")
    }
}