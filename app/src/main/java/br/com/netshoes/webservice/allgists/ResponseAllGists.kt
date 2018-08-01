package br.com.netshoes.webservice.allgists

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class ResponseAllGists(

	@field:SerializedName("owner")
	val owner: Owner? = null,

	@field:SerializedName("commits_url")
	val commitsUrl: String? = null,

	@field:SerializedName("comments")
	val comments: Int? = null,

	@field:SerializedName("forks_url")
	val forksUrl: String? = null,

	@field:SerializedName("git_push_url")
	val gitPushUrl: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("truncated")
	val truncated: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("public")
	val jsonMemberPublic: Boolean? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("git_pull_url")
	val gitPullUrl: String? = null,

	@field:SerializedName("comments_url")
	val commentsUrl: String? = null,

	@field:SerializedName("files")
	val files: Files? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("user")
	val user: Any? = null,

	@field:SerializedName("node_id")
	val nodeId: String? = null
): Serializable