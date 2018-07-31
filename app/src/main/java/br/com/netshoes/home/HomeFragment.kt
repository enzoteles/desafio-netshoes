package br.com.netshoes.home

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.content.di.ContentModule
import br.com.netshoes.content.di.DaggerContentComponent
import br.com.netshoes.home.di.DaggerHomeComponent
import br.com.netshoes.home.di.HomeModule
import br.com.netshoes.main.MainActivity
import br.com.netshoes.webservice.allgists.ResponseAllGists
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
        presenter.initInteractor()
    }


    override fun initData() {
        presenter.getAllGists().observe(activity as MainActivity, object : Observer<List<ResponseAllGists>>{
            override fun onChanged(response: List<ResponseAllGists>?) {
                HelpLog.info("======> ${response!![0]!!.url}")
            }

        })

    }
}