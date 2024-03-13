package com.app.livechat

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.app.livechat.data.Event
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
    var inProcess= mutableStateOf(false)
    val eventMutableState= mutableStateOf<Event<String>?>(null)
    fun signup(name:String,phone:String,email:String,password:String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful) {

            }
        }
    }

    fun handleException(exception: Exception?=null, customMessage: String="") {
        exception?.printStackTrace()
        val errorMsg=exception?.localizedMessage
        val message= if (customMessage.isNullOrEmpty()) errorMsg else customMessage
    }
}