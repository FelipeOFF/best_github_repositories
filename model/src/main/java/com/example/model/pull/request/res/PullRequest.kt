package com.example.model.pull.request.res

import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("active_lock_reason")
    val activeLockReason: Any?,
    @SerializedName("assignee")
    val assignee: Any?,
    @SerializedName("assignees")
    val assignees: List<Any>?,
    @SerializedName("author_association")
    val authorAssociation: String?,
    @SerializedName("auto_merge")
    val autoMerge: Any?,
    @SerializedName("base")
    val base: Base?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("closed_at")
    val closedAt: Any?,
    @SerializedName("comments_url")
    val commentsUrl: String?,
    @SerializedName("commits_url")
    val commitsUrl: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("diff_url")
    val diffUrl: String?,
    @SerializedName("draft")
    val draft: Boolean?,
    @SerializedName("head")
    val head: Head?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("issue_url")
    val issueUrl: String?,
    @SerializedName("labels")
    val labels: List<Label>?,
    @SerializedName("_links")
    val links: Links?,
    @SerializedName("locked")
    val locked: Boolean?,
    @SerializedName("merge_commit_sha")
    val mergeCommitSha: String?,
    @SerializedName("merged_at")
    val mergedAt: Any?,
    @SerializedName("milestone")
    val milestone: Any?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("patch_url")
    val patchUrl: String?,
    @SerializedName("requested_reviewers")
    val requestedReviewers: List<Any>?,
    @SerializedName("requested_teams")
    val requestedTeams: List<Any>?,
    @SerializedName("review_comment_url")
    val reviewCommentUrl: String?,
    @SerializedName("review_comments_url")
    val reviewCommentsUrl: String?,
    @SerializedName("state")
    val state: StateEnum?,
    @SerializedName("statuses_url")
    val statusesUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("user")
    val user: User?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PullRequest

        if (activeLockReason != other.activeLockReason) return false
        if (assignee != other.assignee) return false
        if (assignees != other.assignees) return false
        if (authorAssociation != other.authorAssociation) return false
        if (autoMerge != other.autoMerge) return false
        if (base != other.base) return false
        if (body != other.body) return false
        if (closedAt != other.closedAt) return false
        if (commentsUrl != other.commentsUrl) return false
        if (commitsUrl != other.commitsUrl) return false
        if (createdAt != other.createdAt) return false
        if (diffUrl != other.diffUrl) return false
        if (draft != other.draft) return false
        if (head != other.head) return false
        if (htmlUrl != other.htmlUrl) return false
        if (id != other.id) return false
        if (issueUrl != other.issueUrl) return false
        if (labels != other.labels) return false
        if (links != other.links) return false
        if (locked != other.locked) return false
        if (mergeCommitSha != other.mergeCommitSha) return false
        if (mergedAt != other.mergedAt) return false
        if (milestone != other.milestone) return false
        if (nodeId != other.nodeId) return false
        if (number != other.number) return false
        if (patchUrl != other.patchUrl) return false
        if (requestedReviewers != other.requestedReviewers) return false
        if (requestedTeams != other.requestedTeams) return false
        if (reviewCommentUrl != other.reviewCommentUrl) return false
        if (reviewCommentsUrl != other.reviewCommentsUrl) return false
        if (state != other.state) return false
        if (statusesUrl != other.statusesUrl) return false
        if (title != other.title) return false
        if (updatedAt != other.updatedAt) return false
        if (url != other.url) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = activeLockReason?.hashCode() ?: 0
        result = 31 * result + (assignee?.hashCode() ?: 0)
        result = 31 * result + (assignees?.hashCode() ?: 0)
        result = 31 * result + (authorAssociation?.hashCode() ?: 0)
        result = 31 * result + (autoMerge?.hashCode() ?: 0)
        result = 31 * result + (base?.hashCode() ?: 0)
        result = 31 * result + (body?.hashCode() ?: 0)
        result = 31 * result + (closedAt?.hashCode() ?: 0)
        result = 31 * result + (commentsUrl?.hashCode() ?: 0)
        result = 31 * result + (commitsUrl?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (diffUrl?.hashCode() ?: 0)
        result = 31 * result + (draft?.hashCode() ?: 0)
        result = 31 * result + (head?.hashCode() ?: 0)
        result = 31 * result + (htmlUrl?.hashCode() ?: 0)
        result = 31 * result + (id ?: 0)
        result = 31 * result + (issueUrl?.hashCode() ?: 0)
        result = 31 * result + (labels?.hashCode() ?: 0)
        result = 31 * result + (links?.hashCode() ?: 0)
        result = 31 * result + (locked?.hashCode() ?: 0)
        result = 31 * result + (mergeCommitSha?.hashCode() ?: 0)
        result = 31 * result + (mergedAt?.hashCode() ?: 0)
        result = 31 * result + (milestone?.hashCode() ?: 0)
        result = 31 * result + (nodeId?.hashCode() ?: 0)
        result = 31 * result + (number ?: 0)
        result = 31 * result + (patchUrl?.hashCode() ?: 0)
        result = 31 * result + (requestedReviewers?.hashCode() ?: 0)
        result = 31 * result + (requestedTeams?.hashCode() ?: 0)
        result = 31 * result + (reviewCommentUrl?.hashCode() ?: 0)
        result = 31 * result + (reviewCommentsUrl?.hashCode() ?: 0)
        result = 31 * result + (state?.hashCode() ?: 0)
        result = 31 * result + (statusesUrl?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (user?.hashCode() ?: 0)
        return result
    }
}
