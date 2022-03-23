package com.sim2g.icbt.data.repository

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Farouk Sabiou on 2/28/22.
 */
class UserRepository @Inject constructor(private val sharedPreferences: SharedPreferences) {

    // save the user id after successfull login
    fun saveUserID(identifier: String?) {
        sharedPreferences.edit().putString("uid", identifier).apply()
    }

    // get the saved user id
    fun getSavedID(key: String): String? {
        return sharedPreferences.getString(key, "")
    }
}