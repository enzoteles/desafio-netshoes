package br.com.netshoes.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.details.DetailFragment
import br.com.netshoes.details.DetailMVP
import br.com.netshoes.home.adapter.HomeAdapterBinding
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

class HomeFragment: HelpFragment(){

    lateinit var viewModel: HomeViewModel
    lateinit var detail: DetailFragment
    lateinit var listGists: MutableList<ResponseAllGists>
    lateinit var adapter: HomeAdapterBinding
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.home, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initInjection()
        initView()
        initData()
    }

    fun initInjection() {

        /*val homeComponent = DaggerHomeComponent.builder()
                .homeModule(HomeModule(this))
                .build()
        homeComponent.inject(this)*/
    }

    fun initView() {
        Constant.toolbar!!.ct_tb_tv_title.setText("Home")
        Constant.tag_frag = "HOME"
        viewModel = ViewModelProviders.of(activity as MainActivity).get(HomeViewModel::class.java)
        avi.show()
    }


    fun initData() {

        viewModel.getAllGists().observe(activity as MainActivity, object : Observer<List<ResponseAllGists>>{
            override fun onChanged(response: List<ResponseAllGists>?) {
                setrecyclerview(response)
            }

        })

    }

    fun setrecyclerview(gits: List<ResponseAllGists>?) {
        avi.hide()
        hm_rv_gists.visibility = View.VISIBLE
        listGists = arrayListOf()

        gits!!.forEach {
            it-> listGists.add(it)
        }

        adapter = HomeAdapterBinding(listGists, activity.baseContext, this)
        hm_rv_gists.adapter = adapter
        layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.VERTICAL, false)
        hm_rv_gists.layoutManager = layoutManager
    }

    fun detailGistis(gists: ResponseAllGists?) {
        Constant.tag_list = "1"
        val args = Bundle()
        args.putSerializable("gists", gists)
        detail = DetailFragment()
        (detail as HelpFragment).arguments = args
        HelpSecurity.manager!!.replaceFragment(R.id.options, detail as HelpFragment, "detail", true)
    }

}