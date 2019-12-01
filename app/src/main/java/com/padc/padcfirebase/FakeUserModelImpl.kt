package com.padc.padcfirebase

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseUser
import com.padc.padcfirebase.data.models.FirebaseModel
import com.padc.padcfirebase.data.models.UserAuthenticationModel
import com.padc.padcfirebase.data.vos.ArticleVO

object FakeUserModelImpl: UserAuthenticationModel {
    override val currentUser: FirebaseUser?
        get() = fakeUser

    var login: Boolean = false
    var fakeUser: FirebaseUser? = null

    override fun isLoginUser(): Boolean {
        return login
    }

    override fun firebaseAuthWithGoogle(
        account: GoogleSignInAccount,
        onError: (String) -> Unit
    ): LiveData<FirebaseUser> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logOut() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}