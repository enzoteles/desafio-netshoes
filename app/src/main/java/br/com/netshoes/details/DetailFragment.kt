package br.com.netshoes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.webservice.allgists.ResponseAllGists
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail.*

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class DetailFragment : HelpFragment(), DetailMVP.View{

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.detail, container, false)
        Constant.tag_frag = "DETAIL"
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initInjection() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        val args = arguments
        val gists = args.getSerializable("gists") as ResponseAllGists

        dt_tv_name_author.setText("${gists.owner!!.login}")
        dt_tv_gists_language.setText("${gists!!.nodeId}")
        dt_tv_gists_title.setText("${gists.url}")
        Picasso.get().load("${gists!!.owner!!.avatarUrl}").into(dt_im_author)
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}