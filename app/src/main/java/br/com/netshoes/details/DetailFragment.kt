package br.com.netshoes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.details.di.DaggerDetailComponent
import br.com.netshoes.details.di.DetailModule
import br.com.netshoes.webservice.allgists.ResponseAllGists
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail.*
import kotlinx.android.synthetic.main.toolbar.view.*
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class DetailFragment : HelpFragment(), DetailMVP.View {

    lateinit var gistsPO: ResponseAllGistsPO
    @Inject
    lateinit var presenter: DetailMVP.Presenter
    lateinit var gists: ResponseAllGists
    lateinit var gistsF: ResponseAllGistsPO

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.detail, container, false)
        Constant.tag_frag = "DETAIL"
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInjection()
        initView()
    }

    override fun initInjection() {
        val detailComponent = DaggerDetailComponent.builder()
                .detailModule(DetailModule(this))
                .build()
        detailComponent.inject(this)
        presenter.initInteractor()
    }

    override fun initView() {
        Constant.toolbar!!.ct_tb_tv_title.setText("Detail")

        if(Constant.tag_list.equals("1")){

            val args = arguments
            gists = args.getSerializable("gists") as ResponseAllGists

            dt_tv_name_author.setText("${gists.owner!!.login}")
            dt_tv_gists_language.setText("${gists!!.nodeId}")
            dt_tv_gists_title.setText("${gists.url}")
            Picasso.get().load("${gists!!.owner!!.avatarUrl}").into(dt_im_author)

            Constant.database!!.gistsDao().allGists().forEach { it ->
                if (gists.id == it.id && it.isFavorites == true) {
                    dt_cb_favorites.isChecked = true
                }
            }

            initData()
        }else{

            val args = arguments
            gistsF = args.getSerializable("gistsPO") as ResponseAllGistsPO

            dt_tv_name_author.setText("${gistsF.nameAuthor}")
            dt_tv_gists_language.setText("${gistsF.languageGists}")
            dt_tv_gists_title.setText("${gistsF.languageGists}")
            Picasso.get().load("${gistsF.pathPhoto}").into(dt_im_author)

            Constant.database!!.gistsDao().allGists().forEach { it ->
                if (gistsF.id == it.id && it.isFavorites == true) {
                    dt_cb_favorites.isChecked = true
                }
            }
            dt_cb_favorites.isEnabled = false
            dt_cb_favorites.alpha = 0.8f
        }


    }

    override fun initData() {
        dt_cb_favorites.setOnClickListener {

            if ((it as CheckBox).isChecked) {
                gistsPO = ResponseAllGistsPO(gists!!.id.toString(), gists.owner!!.login.toString(),
                        gists!!.owner!!.avatarUrl.toString(), gists.url.toString(), gists!!.nodeId.toString(), true)
                presenter.addGists(gistsPO)
            } else {
                Constant.database!!.gistsDao().allGists().forEach { it ->
                    if (gists.id == it.id) {
                        presenter.deleteGists(it)
                    }
                }
            }
        }
    }
}