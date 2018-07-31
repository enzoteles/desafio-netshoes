package br.com.netshoes.webservice.allgists

import br.com.netshoes.webservice.allgists.Files
import br.com.netshoes.webservice.allgists.Owner

data class ResponseAllGists(
		val owner: Owner? = null,
		val commitsUrl: String? = null,
		val comments: Int? = null,
		val forksUrl: String? = null,
		val gitPushUrl: String? = null,
		val createdAt: String? = null,
		val description: String? = null,
		val truncated: Boolean? = null,
		val url: String? = null,
		val jsonMemberPublic: Boolean? = null,
		val updatedAt: String? = null,
		val htmlUrl: String? = null,
		val gitPullUrl: String? = null,
		val commentsUrl: String? = null,
		val files: Files? = null,
		val id: String? = null,
		val user: Any? = null,
		val nodeId: String? = null
)
