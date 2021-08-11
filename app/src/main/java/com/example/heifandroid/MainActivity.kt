package com.example.heifandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openWelcomeFragment()
    }

    private fun openWelcomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainActivity, WelcomeFragment())
            .commit()
    }

    override fun openFoodFragmentFirst() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.clMain, MainFragment())
            .commit()
    }
}