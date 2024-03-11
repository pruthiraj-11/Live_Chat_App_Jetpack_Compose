package com.app.livechat

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LCViewModel @Inject constructor(
    val auth:FirebaseAuth
): ViewModel() {
    init {

    }
    fun signup(name:String,phone:String,email:String,password:String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful) {

            }
        }
    }

    fun handleException(exception: Exception?=null, customMessage: String="") {
        exception?.printStackTrace()
    }
}