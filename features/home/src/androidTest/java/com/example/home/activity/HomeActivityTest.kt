package com.example.home.activity

import android.net.Uri
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.example.home.R
import com.example.home.adapter.RecyclerViewMatchers.checkRecyclerViewItem
import com.example.home.gateway.mock.BestGithubRepositoriesMockWebServer
import com.example.home.gateway.mock.BestGithubRepositoriesMockWebServer.MOCK_SERVER_PORT
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.lang.Thread.sleep

class HomeActivityTest {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    private val mockServer: MockWebServer by lazy {
        MockWebServer()
    }

    @Before
    fun setup() {
        mockServer.start(MOCK_SERVER_PORT)
    }

    @After
    fun tearDown() {
        mockServer.close()
    }

    @Test
    fun shouldDisplayTitleApplication() {
        mockServer.dispatcher = getAllDispatcher(BestGithubRepositoriesMockWebServer.successRepositoryResponse())
        launchActivity<HomeActivity>().apply {
            val title = context.getString(R.string.home_toolbar_title)
            moveToState(Lifecycle.State.RESUMED)

            Espresso.onView(ViewMatchers.withText(title))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }
    }

    @Test
    fun shouldDisplayListWithFirstValueApplication() {
        val nameOfFirstRepository = "Teste"
        mockServer.dispatcher = getAllDispatcher(BestGithubRepositoriesMockWebServer.successRepositoryResponse(nameOfFirstRepository))
        launchActivity<HomeActivity>().apply {
            moveToState(Lifecycle.State.RESUMED)

            checkRecyclerViewItem(R.id.recycler, 0, ViewMatchers.withText(nameOfFirstRepository))

            sleep(20000)
        }
    }

    private fun getAllDispatcher(usersMockResponse: MockResponse) = object : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            val url = Uri.parse(request.path)
            return when (url.path) {
                "/search/repositories" -> usersMockResponse
                else -> BestGithubRepositoriesMockWebServer.errorRepositoryResponse
            }
        }
    }
}
