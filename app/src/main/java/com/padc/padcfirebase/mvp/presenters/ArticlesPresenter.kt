package com.padc.padcfirebase.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.padc.padcfirebase.FakeModelImpl
import com.padc.padcfirebase.FakeUserModelImpl
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.FirebaseModelImpl
import com.padc.padcfirebase.data.models.UserAuthenticationModel
import com.padc.padcfirebase.data.models.UserAuthenticationModelImpl
import com.padc.padcfirebase.data.vos.ArticleVO
import com.padc.padcfirebase.delegates.ArticleItemDelegate
import com.padc.padcfirebase.mvp.views.ArticlesView
import java.util.*

class ArticlesPresenter: BaseGoogleSignInPresenter<ArticlesView>(), ArticleItemDelegate {

    private val model : FirebaseModel = FakeModelImpl
    private val userModel: UserAuthenticationModel = FakeUserModelImpl
    private val clearedLiveData = MutableLiveData<Unit>()

    fun onUIReady(owner: LifecycleOwner){
        model.getAllArticles(clearedLiveData).observe(owner, Observer {
            mView.showArticles(it)
        })
    }

    override fun onArticleItemClicked(data: ArticleVO) {
        mView.navigateToDetail(data.id)
    }

    override fun onCleared() {
        clearedLiveData.value = Unit
        super.onCleared()
    }

    fun onStart() {
        userModel.currentUser?.let {
            mView.showLoginUser(it)
        } ?: mView.showLogoutUser()
    }

    fun onUserProfileClicked(context: Context) {
        if (userModel.isLoginUser()){
            userModel.logOut()
            onStart()

        } else {
            googleSignIn(context)
        }
    }
}