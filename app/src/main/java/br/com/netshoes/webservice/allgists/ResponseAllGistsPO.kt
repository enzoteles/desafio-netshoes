package br.com.netshoes.webservice.allgists

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class ResponseAllGistsPO(

	@PrimaryKey
	val id: String,
	val nameAuthor: String,
	val pathPhoto: String,
	val titleGists: String,
	val languageGists: String,
	val isFavorites: Boolean

):Serializable