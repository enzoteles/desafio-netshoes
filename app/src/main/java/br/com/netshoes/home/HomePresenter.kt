package br.com.netshoes.home

import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.home.di.DaggerHomeComponent
import br.com.netshoes.home.di.HomeModule
import br.com.netshoes.webservice.allgists.ResponseAllGists
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomePresenter(val view: HomeMVP.View): HomeMVP.Presenter{

    @Inject
    lateinit var interactor: HomeMVP.Interactor

    override fun getAllGists(): MutableLiveData<List<ResponseAllGists>> {
        return interactor.getAllGists()
    }

    override fun initInteractor() {
        val homeComponent = DaggerHomeComponent.builder()
                .homeModule(HomeModule(view))
                .build()
        homeComponent.inject(this)
    }

    override fun error(message: String?) {
        HelpLog.error("${message}")
        if(message.equals(Constant.HTTP404.trim())){
            Toast.makeText(Constant.context, "${message}", Toast.LENGTH_SHORT).show()
        }else if(message.equals(Constant.NOADDRESS.trim())){
            Toast.makeText(Constant.context, Constant.activity!!.resources.getString(R.string.msg_fail_connection), Toast.LENGTH_SHORT).show()
        }
    }
}