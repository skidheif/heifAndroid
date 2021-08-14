package com.example.heifandroid

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper {

    companion object {
        val SP_NAME = "welcomeButtonDontShowAgain"
        val SP_WELCOME_BUTTON_CLICKED = "welcomeButtonClicked"
        lateinit var instance: SharedPreferences

        fun initPreferences(context: Context) {
            instance = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        }

        fun putBoolean(key: String, value: Boolean) {
            instance.edit().putBoolean(key, value).apply()
        }
    }
}