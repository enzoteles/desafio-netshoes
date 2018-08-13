package br.com.netshoes.home.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.netshoes.BR
import br.com.netshoes.R
import br.com.netshoes.home.HomeMVP
import kotlinx.android.synthetic.main.item_list_gists.view.*
import br.com.netshoes.webservice.allgists.ResponseAllGists
import com.squareup.picasso.Picasso

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class HomeAdapterBinding(val listGists: List<ResponseAllGists?>?, val context: Context) : RecyclerView.Adapter<HomeAdapterBinding.ViewHoder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_list_gists, parent, false)

        return ViewHoder(binding)
    }

    override fun getItemCount(): Int = listGists!!.size

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        holder.bind(listGists!![position])
    }


    class ViewHoder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gists: ResponseAllGists?) {

            binding.setVariable(BR.gists, gists)
            binding.executePendingBindings()
        }
    }

}