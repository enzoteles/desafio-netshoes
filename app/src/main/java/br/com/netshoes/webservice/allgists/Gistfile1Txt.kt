package br.com.netshoes.webservice.allgists

import android.arch.persistence.room.Entity
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Gistfile1Txt(

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("raw_url")
	val rawUrl: String? = null
)