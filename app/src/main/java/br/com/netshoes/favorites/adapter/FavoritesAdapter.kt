package br.com.netshoes.favorites.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.netshoes.R
import br.com.netshoes.favorites.FavoritesMVP
import br.com.netshoes.home.HomeMVP
import kotlinx.android.synthetic.main.item_list_gists.view.*
import br.com.netshoes.webservice.allgists.ResponseAllGists
import br.com.netshoes.webservice.allgists.ResponseAllGistsPO
import com.squareup.picasso.Picasso

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
class FavoritesAdapter(val listGists: List<ResponseAllGistsPO?>?, val context: Context, val view: FavoritesMVP.View) : RecyclerView.Adapter<FavoritesAdapter.ViewHoder>() {

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

            it.authorName.setText("${gists!!.nameAuthor}")
            it.gistsLanguange.setText("${gists!!.languageGists}")
            it.gistsTitle.setText("${gists.titleGists}")
            Picasso.get().load("${gists!!.pathPhoto}").into(it.imgAuthor);
            it.itemView.setOnClickListener {
                view.detailGistis(gists)
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