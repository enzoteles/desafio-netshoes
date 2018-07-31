package br.com.netshoes.webservice.gists

data class ResponseGists(
		val owner: Owner? = null,
		val forks: List<Any?>? = null,
		val commitsUrl: String? = null,
		val comments: Int? = null,
		val forksUrl: String? = null,
		val gitPushUrl: String? = null,
		val createdAt: String? = null,
		val description: String? = null,
		val truncated: Boolean? = null,
		val history: List<HistoryItem?>? = null,
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
