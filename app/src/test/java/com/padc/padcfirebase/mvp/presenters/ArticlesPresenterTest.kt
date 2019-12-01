package com.padc.padcfirebase.mvp.presenters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.padc.padcfirebase.FakeModelImpl
import com.padc.padcfirebase.FakeUserModelImpl
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.mvp.views.ArticlesView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ArticlesPresenterTest {

    private lateinit var presenter: ArticlesPresenter
    private lateinit var view: ArticlesView

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {

        view = mock(ArticlesView::class.java)
        presenter = ArticlesPresenter()

        presenter.initPresenter(view)

    }

    @Test
    fun onUIReady_getArticles() {
        val lifecycleOwner = object : LifecycleOwner {

            override fun getLifecycle(): Lifecycle {
                return LifecycleRegistry(this).apply {
                    handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }
            }

        }

        presenter.onUIReady(lifecycleOwner)
        verify(view).showArticles(FakeModelImpl.articles)
    }

    @Test
    fun onArticleItemClick_navigateDetails() {
        val clickedArticle =
            ArticleVO("232323", "", "Article1", "Body1", 0, emptyMap(), 0, "27-7-19")

        presenter.onArticleItemClicked(clickedArticle)
        verify(view).navigateToDetail(clickedArticle.id)
    }

    @Test
    fun onStart_whenUserLoggedOut() {
        FakeUserModelImpl.login = false

        presenter.onStart()
        verify(view).showLogoutUser()
    }


}