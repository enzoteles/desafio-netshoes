package br.com.netshoes.webservice.gists

data class HistoryItem(
        val committedAt: String? = null,
        val changeStatus: ChangeStatus? = null,
        val user: User? = null,
        val version: String? = null,
        val url: String? = null
)
