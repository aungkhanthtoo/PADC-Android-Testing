package com.padc.padcfirebase

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.vos.ArticleVO

object FakeModelImpl: FirebaseModel {

    var articles = listOf<ArticleVO>(
        ArticleVO("232323", "", "Article1", "Body1", 0, emptyMap(), 0, "27-7-19"),
        ArticleVO("2134324", "", "Article2", "Body2", 0, emptyMap(), 0, "27-7-19"),
        ArticleVO("546456", "", "Article3", "Body3", 0, emptyMap(), 0, "27-7-19"),
        ArticleVO("67575675", "", "Article4", "Body4", 0, emptyMap(), 0, "27-7-19")
    )

    override fun getAllArticles(cleared: LiveData<Unit>): LiveData<List<ArticleVO>> {
        return MutableLiveData(articles)
    }

    override fun getArticleById(id: String, cleared: LiveData<Unit>): LiveData<ArticleVO> {
        return MutableLiveData(articles.first())
    }

    override fun updateClapCount(count: Int, article: ArticleVO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addComment(comment: String, pickedImage: Uri?, article: ArticleVO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}