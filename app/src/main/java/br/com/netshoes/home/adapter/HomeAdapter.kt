package br.com.netshoes.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
class HomeAdapter(val listGists: List<ResponseAllGists?>?, val context: Context) : RecyclerView.Adapter<HomeAdapter.ViewHoder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_gists, parent, false)
        return ViewHoder(view)
    }

    override fun getItemCount(): Int {
        return listGists!!.size
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
        val gists = listGists!![position]

        holder?.let {

            it.authorName.setText("${gists!!.owner!!.login}")
            it.gistsLanguange.setText("${gists!!.nodeId}")
            it.gistsTitle.setText("${gists.url}")
            Picasso.get().load("${gists!!.owner!!.avatarUrl}").into(it.imgAuthor);
            it.itemView.setOnClickListener {
                //view.detailGistis(gists)
            }

        }

    }


    class ViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var authorName = itemView.hm_author_name
        var gistsTitle = itemView.hm_gists_name
        var gistsLanguange = itemView.hm_gists_languange
        var imgAuthor = itemView.hm_author_avatar
    }

}