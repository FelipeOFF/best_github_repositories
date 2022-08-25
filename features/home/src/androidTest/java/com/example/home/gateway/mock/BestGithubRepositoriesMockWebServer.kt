package com.example.home.gateway.mock

import okhttp3.mockwebserver.MockResponse
import java.net.HttpURLConnection

object BestGithubRepositoriesMockWebServer {
    fun successRepositoryResponse(nameOfFirstRepository: String = "poli"): MockResponse {
        val body = """
            {
                "total_count": 10923647,
                "incomplete_results": true,
                "items": [
                    {
                        "id": 159273440,
                        "node_id": "MDEwOlJlcG9zaXRvcnkxNTkyNzM0NDA=",
                        "name": "$nameOfFirstRepository",
                        "full_name": "shzlw/poli",
                        "private": false,
                        "owner": {
                            "login": "shzlw",
                            "id": 4129280,
                            "node_id": "MDQ6VXNlcjQxMjkyODA=",
                            "avatar_url": "https://avatars.githubusercontent.com/u/4129280?v=4",
                            "gravatar_id": "",
                            "url": "https://api.github.com/users/shzlw",
                            "html_url": "https://github.com/shzlw",
                            "followers_url": "https://api.github.com/users/shzlw/followers",
                            "following_url": "https://api.github.com/users/shzlw/following{/other_user}",
                            "gists_url": "https://api.github.com/users/shzlw/gists{/gist_id}",
                            "starred_url": "https://api.github.com/users/shzlw/starred{/owner}{/repo}",
                            "subscriptions_url": "https://api.github.com/users/shzlw/subscriptions",
                            "organizations_url": "https://api.github.com/users/shzlw/orgs",
                            "repos_url": "https://api.github.com/users/shzlw/repos",
                            "events_url": "https://api.github.com/users/shzlw/events{/privacy}",
                            "received_events_url": "https://api.github.com/users/shzlw/received_events",
                            "type": "User",
                            "site_admin": false
                        },
                        "html_url": "https://github.com/shzlw/poli",
                        "description": "An easy-to-use BI server built for SQL lovers. Power data analysis in SQL and gain faster business insights.",
                        "fork": false,
                        "url": "https://api.github.com/repos/shzlw/poli",
                        "forks_url": "https://api.github.com/repos/shzlw/poli/forks",
                        "keys_url": "https://api.github.com/repos/shzlw/poli/keys{/key_id}",
                        "collaborators_url": "https://api.github.com/repos/shzlw/poli/collaborators{/collaborator}",
                        "teams_url": "https://api.github.com/repos/shzlw/poli/teams",
                        "hooks_url": "https://api.github.com/repos/shzlw/poli/hooks",
                        "issue_events_url": "https://api.github.com/repos/shzlw/poli/issues/events{/number}",
                        "events_url": "https://api.github.com/repos/shzlw/poli/events",
                        "assignees_url": "https://api.github.com/repos/shzlw/poli/assignees{/user}",
                        "branches_url": "https://api.github.com/repos/shzlw/poli/branches{/branch}",
                        "tags_url": "https://api.github.com/repos/shzlw/poli/tags",
                        "blobs_url": "https://api.github.com/repos/shzlw/poli/git/blobs{/sha}",
                        "git_tags_url": "https://api.github.com/repos/shzlw/poli/git/tags{/sha}",
                        "git_refs_url": "https://api.github.com/repos/shzlw/poli/git/refs{/sha}",
                        "trees_url": "https://api.github.com/repos/shzlw/poli/git/trees{/sha}",
                        "statuses_url": "https://api.github.com/repos/shzlw/poli/statuses/{sha}",
                        "languages_url": "https://api.github.com/repos/shzlw/poli/languages",
                        "stargazers_url": "https://api.github.com/repos/shzlw/poli/stargazers",
                        "contributors_url": "https://api.github.com/repos/shzlw/poli/contributors",
                        "subscribers_url": "https://api.github.com/repos/shzlw/poli/subscribers",
                        "subscription_url": "https://api.github.com/repos/shzlw/poli/subscription",
                        "commits_url": "https://api.github.com/repos/shzlw/poli/commits{/sha}",
                        "git_commits_url": "https://api.github.com/repos/shzlw/poli/git/commits{/sha}",
                        "comments_url": "https://api.github.com/repos/shzlw/poli/comments{/number}",
                        "issue_comment_url": "https://api.github.com/repos/shzlw/poli/issues/comments{/number}",
                        "contents_url": "https://api.github.com/repos/shzlw/poli/contents/{+path}",
                        "compare_url": "https://api.github.com/repos/shzlw/poli/compare/{base}...{head}",
                        "merges_url": "https://api.github.com/repos/shzlw/poli/merges",
                        "archive_url": "https://api.github.com/repos/shzlw/poli/{archive_format}{/ref}",
                        "downloads_url": "https://api.github.com/repos/shzlw/poli/downloads",
                        "issues_url": "https://api.github.com/repos/shzlw/poli/issues{/number}",
                        "pulls_url": "https://api.github.com/repos/shzlw/poli/pulls{/number}",
                        "milestones_url": "https://api.github.com/repos/shzlw/poli/milestones{/number}",
                        "notifications_url": "https://api.github.com/repos/shzlw/poli/notifications{?since,all,participating}",
                        "labels_url": "https://api.github.com/repos/shzlw/poli/labels{/name}",
                        "releases_url": "https://api.github.com/repos/shzlw/poli/releases{/id}",
                        "deployments_url": "https://api.github.com/repos/shzlw/poli/deployments",
                        "created_at": "2018-11-27T03:56:44Z",
                        "updated_at": "2022-08-24T21:35:25Z",
                        "pushed_at": "2022-07-21T17:40:42Z",
                        "git_url": "git://github.com/shzlw/poli.git",
                        "ssh_url": "git@github.com:shzlw/poli.git",
                        "clone_url": "https://github.com/shzlw/poli.git",
                        "svn_url": "https://github.com/shzlw/poli",
                        "homepage": "https://shzlw.github.io/poli",
                        "size": 21840,
                        "stargazers_count": 1904,
                        "watchers_count": 1904,
                        "language": "Java",
                        "has_issues": true,
                        "has_projects": true,
                        "has_downloads": true,
                        "has_wiki": true,
                        "has_pages": true,
                        "forks_count": 327,
                        "mirror_url": null,
                        "archived": false,
                        "disabled": false,
                        "open_issues_count": 38,
                        "license": {
                            "key": "mit",
                            "name": "MIT License",
                            "spdx_id": "MIT",
                            "url": "https://api.github.com/licenses/mit",
                            "node_id": "MDc6TGljZW5zZTEz"
                        },
                        "allow_forking": true,
                        "is_template": false,
                        "web_commit_signoff_required": false,
                        "topics": [
                            "bigdata",
                            "business-intelligence",
                            "dashboard",
                            "data-visualization",
                            "jdbc",
                            "reactjs",
                            "reporting",
                            "spring-boot",
                            "sql",
                            "sql-editor"
                        ],
                        "visibility": "public",
                        "forks": 327,
                        "open_issues": 38,
                        "watchers": 1904,
                        "default_branch": "master",
                        "score": 1.0
                    }
                ]
            }
        """.trimIndent()

        return MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(body)
    }

    val errorRepositoryUnauthorizedResponse by lazy {
        val body = """
            {
                "message": "Acesso negado"
            }
        """.trimIndent()

        MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_UNAUTHORIZED)
            .setBody(body)
    }

    val errorRepositoryResponse by lazy { MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND) }

    const val MOCK_SERVER_PORT = 8080
}
