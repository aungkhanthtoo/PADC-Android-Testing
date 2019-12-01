package com.padc.padcfirebase.mvp.presenters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.padc.padcfirebase.FakeModelImpl
import com.padc.padcfirebase.FakeUserModelImpl
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.mvp.views.ArticleDetailView
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.verification.VerificationMode

class ArticleDetailPresenterTest {

    private lateinit var presenter: ArticleDetailPresenter
    private lateinit var userModel: FakeUserModelImpl
    private lateinit var model: FakeModelImpl
    private lateinit var view: ArticleDetailView

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        model = FakeModelImpl
        userModel = FakeUserModelImpl
        presenter = ArticleDetailPresenter(model, userModel)
        view = mock(ArticleDetailView::class.java)
        presenter.initPresenter(view)
    }

    @Test
    fun onUIReady() {
        val lifecycleOwner = object : LifecycleOwner {

            override fun getLifecycle(): Lifecycle {
                return LifecycleRegistry(this).apply {
                    handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }
            }

        }

        val article = ArticleVO("67575675", "", "Article4", "Body4", 0, emptyMap(), 0, "27-7-19")

        presenter.onUIReady(lifecycleOwner, article.id)
        verify(view).showArticle(article)
    }

    @Test
    fun onClapped() {

        val lifecycleOwner = object : LifecycleOwner {

            override fun getLifecycle(): Lifecycle {
                return LifecycleRegistry(this).apply {
                    handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }
            }

        }

        val article = ArticleVO("67575675", "", "Article4", "Body4", 0, emptyMap(), 0, "27-7-19")

        presenter.onUIReady(lifecycleOwner, article.id)
        verify(view).showArticle(article)

        presenter.onClapped(1)
        val updated = article.copy(claps = article.claps + 1)
        verify(view, times(2)).showArticle(updated)
    }

    @Test
    fun onCommentClicked() {
        val lifecycleOwner = object : LifecycleOwner {

            override fun getLifecycle(): Lifecycle {
                return LifecycleRegistry(this).apply {
                    handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
                }
            }

        }

        val article = ArticleVO("67575675", "", "Article4", "Body4", 0, emptyMap(), 0, "27-7-19")

        presenter.onUIReady(lifecycleOwner, article.id)
        verify(view).showArticle(article)

        presenter.onCommentSendClicked("Testing")
        verify(view, times(2)).showArticle(any())

    }

    @Test
    fun onCommentSendClicked() {
    }

    @Test
    fun onImagePicked() {


    }

    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T
}