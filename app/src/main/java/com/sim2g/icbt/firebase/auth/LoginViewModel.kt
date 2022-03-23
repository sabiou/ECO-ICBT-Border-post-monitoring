package com.sim2g.icbt.firebase.auth

import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sim2g.icbt.data.persistence.OperatorDAO
import com.sim2g.icbt.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/28/22.
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    // private var auth: FirebaseAuth = Firebase.auth
    enum class AuthenticationState {
        UNAUTHENTICATED,       // Initial state, the user needs to authenticate
        AUTHENTICATED,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    val authenticationState = MutableLiveData<AuthenticationState>()

    // testing that fucking response
    private val _response = MutableLiveData<String>()

    // external immutable livedata
    val response: LiveData<String>
        get() = _response

    fun loginUser(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userUid = task.result.user?.uid
                    userRepository.saveUserID(userUid)
                    authenticationState.value = AuthenticationState.AUTHENTICATED
                    sharedPreferences.edit().putBoolean("loggedIn", true).apply()
                } else {
                    // If sign in fails, display a message to the user.
                    Timber.tag("LoginFragment").w(task.exception, "signInWithEmail:failure")
                    _response.value = task.exception.toString()
                    authenticationState.value = AuthenticationState.UNAUTHENTICATED
                }
            }
    }
}