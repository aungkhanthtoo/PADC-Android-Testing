package com.padc.padcfirebase.mvp.presenters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.UserAuthenticationModel

@Suppress("UNCHECKED_CAST")
class AritcleDetailViewModelFactory(private val model: FirebaseModel, private val userModel: UserAuthenticationModel) :
ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return (ArticleDetailPresenter(model, userModel) as T)
    }
}