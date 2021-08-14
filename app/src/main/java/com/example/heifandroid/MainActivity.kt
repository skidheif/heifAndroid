package com.example.heifandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.heifandroid.SharedPrefHelper.Companion.SP_WELCOME_BUTTON_CLICKED

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SharedPrefHelper.initPreferences(this)
        if (!SharedPrefHelper.instance.getBoolean(SP_WELCOME_BUTTON_CLICKED, false))
            openWelcomeFragment()
        else openFoodFragmentFirst()
    }

    override fun openWelcomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainActivity, WelcomeFragment())
            .commit()
    }

    override fun openFoodFragmentFirst() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainActivity, MainFragment())
            .commit()
    }
}