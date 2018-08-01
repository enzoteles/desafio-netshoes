package br.com.netshoes.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.details.DetailFragment
import br.com.netshoes.details.DetailMVP
import br.com.netshoes.home.adapter.HomeAdapter
import br.com.netshoes.home.di.DaggerHomeComponent
import br.com.netshoes.home.di.HomeModule
import br.com.netshoes.main.MainActivity
import br.com.netshoes.webservice.allgists.ResponseAllGists
import kotlinx.android.synthetic.main.home.*
import kotlinx.android.synthetic.main.toolbar.view.*
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeFragment: HelpFragment(), HomeMVP.View{


    @Inject
    lateinit var presenter: HomeMVP.Presenter
    @Inject
    lateinit var detail: DetailMVP.View
    lateinit var listGists: MutableList<ResponseAllGists>
    lateinit var adapter: HomeAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.home, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Constant.toolbar!!.ct_tb_tv_title.setText("Home")
        initInjection()
        initView()
        initData()
    }

    override fun initInjection() {

        val homeComponent = DaggerHomeComponent.builder()
                .homeModule(HomeModule(this))
                .build()
        homeComponent.inject(this)
    }

    override fun initView() {
        Constant.tag_frag = "HOME"
        presenter.initInteractor()
    }


    override fun initData() {

        presenter.getAllGists().observe(activity as MainActivity, object : Observer<List<ResponseAllGists>>{
            override fun onChanged(response: List<ResponseAllGists>?) {
                setrecyclerview(response)
            }

        })

    }

    override fun setrecyclerview(gits: List<ResponseAllGists>?) {
        listGists = arrayListOf()

        gits!!.forEach {
            it-> listGists.add(it)
        }

        adapter = HomeAdapter(listGists, activity.baseContext, this)
        hm_rv_gists.adapter = adapter
        layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.VERTICAL, false)
        hm_rv_gists.layoutManager = layoutManager
    }

    override fun detailGistis(gists: ResponseAllGists?) {
        val args = Bundle()
        args.putSerializable("gists", gists)
        (detail as HelpFragment).arguments = args
        HelpSecurity.manager!!.replaceFragment(R.id.options, detail as HelpFragment, "detail", true);
    }
}