package br.com.netshoes.home.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.netshoes.BR
import br.com.netshoes.R
import br.com.netshoes.home.HomeFragment
import br.com.netshoes.webservice.allgists.ResponseAllGists

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class HomeAdapterBinding(val listGists: List<ResponseAllGists?>?, val context: Context, val homeFragment: HomeFragment) : RecyclerView.Adapter<HomeAdapterBinding.ViewHoder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_list_gists, parent, false)

        return ViewHoder(binding, homeFragment)
    }

    override fun getItemCount(): Int = listGists!!.size

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.bind(listGists!![position])
    }


    class ViewHoder(val binding: ViewDataBinding, val homeFragment: HomeFragment) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gists: ResponseAllGists?) {

            binding.setVariable(BR.gists, gists)
            binding.setVariable(BR.homeview, homeFragment)
            binding.executePendingBindings()
        }
    }

}