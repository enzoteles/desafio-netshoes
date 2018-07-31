package br.com.netshoes.webservice.gists

data class ChangeStatus(
	val total: Int? = null,
	val additions: Int? = null,
	val deletions: Int? = null
)
