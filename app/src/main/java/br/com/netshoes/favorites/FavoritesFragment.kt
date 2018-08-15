package br.com.netshoes.favorites

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.netshoes.Constant
import br.com.netshoes.R
import br.com.netshoes.favorites.adapter.FavoritesAdapter
import br.com.netshoes.main.MainActivity
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import kotlinx.android.synthetic.main.favorites.*
import kotlinx.android.synthetic.main.toolbar.view.*
import javax.inject.Inject

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class FavoritesFragment: HelpFragment(){

    @Inject
    lateinit var viewModel: FavoritesViewModel
    lateinit var adapter: FavoritesAdapter
    lateinit var layoutManager: LinearLayoutManager
    //@Inject
    //lateinit var detail: DetailMVP.View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.favorites, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Constant.toolbar!!.ct_tb_tv_title.setText("Favorites")
        //initInjection()
        initData()

    }

    /*fun initInjection() {
        val favoritesComponent = DaggerFavoritesComponent.builder()
                .favoritesModule(FavoritesModule(this))
                .build()
        favoritesComponent.inject(this)
        viewModel.initInteractor()
    }*/

    fun initData() {
        viewModel = ViewModelProviders.of(activity as MainActivity).get(FavoritesViewModel::class.java)
        viewModel.loadAllListFavorites().observe(activity as MainActivity, object : Observer<List<ResponseAllGistsPO>> {
            override fun onChanged(response: List<ResponseAllGistsPO>?) {
                setrecyclerview(response)
            }

        })
    }

    fun setrecyclerview(listGists: List<ResponseAllGistsPO>?) {

        if (listGists!!.size > 0){

            ft_tv_title.visibility = View.GONE
            ft_rv_gists.visibility = View.VISIBLE

            adapter = FavoritesAdapter(listGists, activity.baseContext, this)
            ft_rv_gists.adapter = adapter
            layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.VERTICAL, false)
            ft_rv_gists.layoutManager = layoutManager

        }else{

            ft_tv_title.visibility = View.VISIBLE
            ft_rv_gists.visibility = View.GONE
        }

    }

    fun detailGistis(gists: ResponseAllGistsPO?) {
        /*Constant.tag_list = "2"
        val args = Bundle()
        args.putSerializable("gistsPO", gists)
        (detail as HelpFragment).arguments = args
        HelpSecurity.manager!!.replaceFragment(R.id.options, detail as HelpFragment, "detail", true);*/
    }

}
