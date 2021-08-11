package com.example.heifandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Navigation {

    companion object {
        val SHARED_PREF_NAME = "welcomeButtonDontShowAgain"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (WelcomeFragment().sharePref.getBoolean("welcomeButtonClicked", false) == false)
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