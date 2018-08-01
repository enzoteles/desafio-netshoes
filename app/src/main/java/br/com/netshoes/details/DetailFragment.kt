package br.com.netshoes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.webservice.allgists.ResponseAllGists
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class DetailFragment : HelpFragment(), DetailMVP.View{

    lateinit var gistsPO: ResponseAllGistsPO
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
        Constant.toolbar!!.ct_tb_tv_title.setText("Detail")
        val args = arguments
        val gists = args.getSerializable("gists") as ResponseAllGists

        dt_tv_name_author.setText("${gists.owner!!.login}")
        dt_tv_gists_language.setText("${gists!!.nodeId}")
        dt_tv_gists_title.setText("${gists.url}")
        Picasso.get().load("${gists!!.owner!!.avatarUrl}").into(dt_im_author)

        Constant.database!!.gistsDao().allGists().forEach {
            it-> if(gists.id == it.id && it.isFavorites == true){
            dt_cb_favorites.isChecked = true
        }
        }

        dt_cb_favorites.setOnClickListener {

            if((it as CheckBox).isChecked){
                gistsPO = ResponseAllGistsPO(gists!!.id.toString(), gists.owner!!.login.toString(),
                        gists!!.owner!!.avatarUrl.toString(), gists.url.toString(), gists!!.nodeId.toString(), true)
                Constant.database!!.gistsDao().addGists(gistsPO)

            }else{
                Constant.database!!.gistsDao().allGists().forEach {
                    it-> if(gists.id == it.id){
                                Constant.database!!.gistsDao().deleteGists(it)
                          }
                }
            }
        }
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}