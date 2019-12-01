package com.padc.padcfirebase

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.UserAuthenticationModelImpl
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.data.vos.CommentVO
import com.padc.padcfirebase.data.vos.UserVO

object FakeModelImpl: FirebaseModel {

    var articles = listOf<ArticleVO>(
        ArticleVO("232323", "", "Article1", "Body1", 0, emptyMap(), 0, "27-7-19"),
        ArticleVO("2134324", "", "Article2", "Body2", 0, emptyMap(), 0, "27-7-19"),
        ArticleVO("546456", "", "Article3", "Body3", 0, emptyMap(), 0, "27-7-19"),
        ArticleVO("67575675", "", "Article4", "Body4", 0, emptyMap(), 0, "27-7-19")
    )

    private val _articles = MutableLiveData<List<ArticleVO>>(articles)
    private val _article = MutableLiveData<ArticleVO>()

    override fun getAllArticles(cleared: LiveData<Unit>): LiveData<List<ArticleVO>> {
        return _articles
    }

    override fun getArticleById(id: String, cleared: LiveData<Unit>): LiveData<ArticleVO> {
        return _article.apply {
            value = articles.first { it.id == id }
        }
    }

    override fun updateClapCount(count: Int, article: ArticleVO) {
        _article.value = articles.first { it.id == article.id }.apply {
            claps = article.claps + count
        }
    }

    override fun addComment(comment: String, pickedImage: Uri?, article: ArticleVO) {
        val id = System.currentTimeMillis().toString()

        val newComment = CommentVO(
            id, "", comment,
            UserVO(
                "",
                "",
                "")
        )


        val update = article.comments + hashMapOf(id to newComment)

        _article.value = article.copy(comments = update)
    }
}