package com.example.model.repository.res

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repository(
    @SerializedName("allow_forking")
    val allowForking: Boolean?,
    @SerializedName("archive_url")
    val archiveUrl: String?,
    @SerializedName("archived")
    val archived: Boolean?,
    @SerializedName("assignees_url")
    val assigneesUrl: String?,
    @SerializedName("blobs_url")
    val blobsUrl: String?,
    @SerializedName("branches_url")
    val branchesUrl: String?,
    @SerializedName("clone_url")
    val cloneUrl: String?,
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String?,
    @SerializedName("comments_url")
    val commentsUrl: String?,
    @SerializedName("commits_url")
    val commitsUrl: String?,
    @SerializedName("compare_url")
    val compareUrl: String?,
    @SerializedName("contents_url")
    val contentsUrl: String?,
    @SerializedName("contributors_url")
    val contributorsUrl: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("default_branch")
    val defaultBranch: String?,
    @SerializedName("deployments_url")
    val deploymentsUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("disabled")
    val disabled: Boolean?,
    @SerializedName("downloads_url")
    val downloadsUrl: String?,
    @SerializedName("events_url")
    val eventsUrl: String?,
    @SerializedName("fork")
    val fork: Boolean?,
    @SerializedName("forks")
    val forks: Int?,
    @SerializedName("forks_count")
    val forksCount: Int?,
    @SerializedName("forks_url")
    val forksUrl: String?,
    @SerializedName("full_name")
    val fullName: String?,
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String?,
    @SerializedName("git_refs_url")
    val gitRefsUrl: String?,
    @SerializedName("git_tags_url")
    val gitTagsUrl: String?,
    @SerializedName("git_url")
    val gitUrl: String?,
    @SerializedName("has_downloads")
    val hasDownloads: Boolean?,
    @SerializedName("has_issues")
    val hasIssues: Boolean?,
    @SerializedName("has_pages")
    val hasPages: Boolean?,
    @SerializedName("has_projects")
    val hasProjects: Boolean?,
    @SerializedName("has_wiki")
    val hasWiki: Boolean?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("hooks_url")
    val hooksUrl: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("is_template")
    val isTemplate: Boolean?,
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String?,
    @SerializedName("issue_events_url")
    val issueEventsUrl: String?,
    @SerializedName("issues_url")
    val issuesUrl: String?,
    @SerializedName("keys_url")
    val keysUrl: String?,
    @SerializedName("labels_url")
    val labelsUrl: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("languages_url")
    val languagesUrl: String?,
    @SerializedName("merges_url")
    val mergesUrl: String?,
    @SerializedName("milestones_url")
    val milestonesUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("notifications_url")
    val notificationsUrl: String?,
    @SerializedName("open_issues")
    val openIssues: Int?,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int?,
    @SerializedName("owner")
    val owner: Owner?,
    @SerializedName("private")
    val isAPrivateRepository: Boolean?,
    @SerializedName("pulls_url")
    val pullsUrl: String?,
    @SerializedName("pushed_at")
    val pushedAt: String?,
    @SerializedName("releases_url")
    val releasesUrl: String?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("ssh_url")
    val sshUrl: String?,
    @SerializedName("stargazers_count")
    val stargazersCount: Int?,
    @SerializedName("stargazers_url")
    val stargazersUrl: String?,
    @SerializedName("statuses_url")
    val statusesUrl: String?,
    @SerializedName("subscribers_url")
    val subscribersUrl: String?,
    @SerializedName("subscription_url")
    val subscriptionUrl: String?,
    @SerializedName("svn_url")
    val svnUrl: String?,
    @SerializedName("tags_url")
    val tagsUrl: String?,
    @SerializedName("teams_url")
    val teamsUrl: String?,
    @SerializedName("topics")
    val topics: List<String?>?,
    @SerializedName("trees_url")
    val treesUrl: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("visibility")
    val visibility: String?,
    @SerializedName("watchers")
    val watchers: Int?,
    @SerializedName("watchers_count")
    val watchersCount: Int?,
    @SerializedName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean?
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Repository

        if (allowForking != other.allowForking) return false
        if (archiveUrl != other.archiveUrl) return false
        if (archived != other.archived) return false
        if (assigneesUrl != other.assigneesUrl) return false
        if (blobsUrl != other.blobsUrl) return false
        if (branchesUrl != other.branchesUrl) return false
        if (cloneUrl != other.cloneUrl) return false
        if (collaboratorsUrl != other.collaboratorsUrl) return false
        if (commentsUrl != other.commentsUrl) return false
        if (commitsUrl != other.commitsUrl) return false
        if (compareUrl != other.compareUrl) return false
        if (contentsUrl != other.contentsUrl) return false
        if (contributorsUrl != other.contributorsUrl) return false
        if (createdAt != other.createdAt) return false
        if (defaultBranch != other.defaultBranch) return false
        if (deploymentsUrl != other.deploymentsUrl) return false
        if (description != other.description) return false
        if (disabled != other.disabled) return false
        if (downloadsUrl != other.downloadsUrl) return false
        if (eventsUrl != other.eventsUrl) return false
        if (fork != other.fork) return false
        if (forks != other.forks) return false
        if (forksCount != other.forksCount) return false
        if (forksUrl != other.forksUrl) return false
        if (fullName != other.fullName) return false
        if (gitCommitsUrl != other.gitCommitsUrl) return false
        if (gitRefsUrl != other.gitRefsUrl) return false
        if (gitTagsUrl != other.gitTagsUrl) return false
        if (gitUrl != other.gitUrl) return false
        if (hasDownloads != other.hasDownloads) return false
        if (hasIssues != other.hasIssues) return false
        if (hasPages != other.hasPages) return false
        if (hasProjects != other.hasProjects) return false
        if (hasWiki != other.hasWiki) return false
        if (homepage != other.homepage) return false
        if (hooksUrl != other.hooksUrl) return false
        if (htmlUrl != other.htmlUrl) return false
        if (id != other.id) return false
        if (isTemplate != other.isTemplate) return false
        if (issueCommentUrl != other.issueCommentUrl) return false
        if (issueEventsUrl != other.issueEventsUrl) return false
        if (issuesUrl != other.issuesUrl) return false
        if (keysUrl != other.keysUrl) return false
        if (labelsUrl != other.labelsUrl) return false
        if (language != other.language) return false
        if (languagesUrl != other.languagesUrl) return false
        if (mergesUrl != other.mergesUrl) return false
        if (milestonesUrl != other.milestonesUrl) return false
        if (name != other.name) return false
        if (nodeId != other.nodeId) return false
        if (notificationsUrl != other.notificationsUrl) return false
        if (openIssues != other.openIssues) return false
        if (openIssuesCount != other.openIssuesCount) return false
        if (owner != other.owner) return false
        if (isAPrivateRepository != other.isAPrivateRepository) return false
        if (pullsUrl != other.pullsUrl) return false
        if (pushedAt != other.pushedAt) return false
        if (releasesUrl != other.releasesUrl) return false
        if (score != other.score) return false
        if (size != other.size) return false
        if (sshUrl != other.sshUrl) return false
        if (stargazersCount != other.stargazersCount) return false
        if (stargazersUrl != other.stargazersUrl) return false
        if (statusesUrl != other.statusesUrl) return false
        if (subscribersUrl != other.subscribersUrl) return false
        if (subscriptionUrl != other.subscriptionUrl) return false
        if (svnUrl != other.svnUrl) return false
        if (tagsUrl != other.tagsUrl) return false
        if (teamsUrl != other.teamsUrl) return false
        if (topics != other.topics) return false
        if (treesUrl != other.treesUrl) return false
        if (updatedAt != other.updatedAt) return false
        if (url != other.url) return false
        if (visibility != other.visibility) return false
        if (watchers != other.watchers) return false
        if (watchersCount != other.watchersCount) return false
        if (webCommitSignoffRequired != other.webCommitSignoffRequired) return false

        return true
    }

    override fun hashCode(): Int {
        var result = allowForking?.hashCode() ?: 0
        result = 31 * result + (archiveUrl?.hashCode() ?: 0)
        result = 31 * result + (archived?.hashCode() ?: 0)
        result = 31 * result + (assigneesUrl?.hashCode() ?: 0)
        result = 31 * result + (blobsUrl?.hashCode() ?: 0)
        result = 31 * result + (branchesUrl?.hashCode() ?: 0)
        result = 31 * result + (cloneUrl?.hashCode() ?: 0)
        result = 31 * result + (collaboratorsUrl?.hashCode() ?: 0)
        result = 31 * result + (commentsUrl?.hashCode() ?: 0)
        result = 31 * result + (commitsUrl?.hashCode() ?: 0)
        result = 31 * result + (compareUrl?.hashCode() ?: 0)
        result = 31 * result + (contentsUrl?.hashCode() ?: 0)
        result = 31 * result + (contributorsUrl?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (defaultBranch?.hashCode() ?: 0)
        result = 31 * result + (deploymentsUrl?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (disabled?.hashCode() ?: 0)
        result = 31 * result + (downloadsUrl?.hashCode() ?: 0)
        result = 31 * result + (eventsUrl?.hashCode() ?: 0)
        result = 31 * result + (fork?.hashCode() ?: 0)
        result = 31 * result + (forks ?: 0)
        result = 31 * result + (forksCount ?: 0)
        result = 31 * result + (forksUrl?.hashCode() ?: 0)
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (gitCommitsUrl?.hashCode() ?: 0)
        result = 31 * result + (gitRefsUrl?.hashCode() ?: 0)
        result = 31 * result + (gitTagsUrl?.hashCode() ?: 0)
        result = 31 * result + (gitUrl?.hashCode() ?: 0)
        result = 31 * result + (hasDownloads?.hashCode() ?: 0)
        result = 31 * result + (hasIssues?.hashCode() ?: 0)
        result = 31 * result + (hasPages?.hashCode() ?: 0)
        result = 31 * result + (hasProjects?.hashCode() ?: 0)
        result = 31 * result + (hasWiki?.hashCode() ?: 0)
        result = 31 * result + (homepage?.hashCode() ?: 0)
        result = 31 * result + (hooksUrl?.hashCode() ?: 0)
        result = 31 * result + (htmlUrl?.hashCode() ?: 0)
        result = 31 * result + (id ?: 0)
        result = 31 * result + (isTemplate?.hashCode() ?: 0)
        result = 31 * result + (issueCommentUrl?.hashCode() ?: 0)
        result = 31 * result + (issueEventsUrl?.hashCode() ?: 0)
        result = 31 * result + (issuesUrl?.hashCode() ?: 0)
        result = 31 * result + (keysUrl?.hashCode() ?: 0)
        result = 31 * result + (labelsUrl?.hashCode() ?: 0)
        result = 31 * result + (language?.hashCode() ?: 0)
        result = 31 * result + (languagesUrl?.hashCode() ?: 0)
        result = 31 * result + (mergesUrl?.hashCode() ?: 0)
        result = 31 * result + (milestonesUrl?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (nodeId?.hashCode() ?: 0)
        result = 31 * result + (notificationsUrl?.hashCode() ?: 0)
        result = 31 * result + (openIssues ?: 0)
        result = 31 * result + (openIssuesCount ?: 0)
        result = 31 * result + (owner?.hashCode() ?: 0)
        result = 31 * result + (isAPrivateRepository?.hashCode() ?: 0)
        result = 31 * result + (pullsUrl?.hashCode() ?: 0)
        result = 31 * result + (pushedAt?.hashCode() ?: 0)
        result = 31 * result + (releasesUrl?.hashCode() ?: 0)
        result = 31 * result + (score?.hashCode() ?: 0)
        result = 31 * result + (size ?: 0)
        result = 31 * result + (sshUrl?.hashCode() ?: 0)
        result = 31 * result + (stargazersCount ?: 0)
        result = 31 * result + (stargazersUrl?.hashCode() ?: 0)
        result = 31 * result + (statusesUrl?.hashCode() ?: 0)
        result = 31 * result + (subscribersUrl?.hashCode() ?: 0)
        result = 31 * result + (subscriptionUrl?.hashCode() ?: 0)
        result = 31 * result + (svnUrl?.hashCode() ?: 0)
        result = 31 * result + (tagsUrl?.hashCode() ?: 0)
        result = 31 * result + (teamsUrl?.hashCode() ?: 0)
        result = 31 * result + (topics?.hashCode() ?: 0)
        result = 31 * result + (treesUrl?.hashCode() ?: 0)
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (visibility?.hashCode() ?: 0)
        result = 31 * result + (watchers ?: 0)
        result = 31 * result + (watchersCount ?: 0)
        result = 31 * result + (webCommitSignoffRequired?.hashCode() ?: 0)
        return result
    }
}
