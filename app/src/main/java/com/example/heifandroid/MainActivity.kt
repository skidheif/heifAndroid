package com.example.heifandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Navigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openAuthFragment()
    }

    override fun openAuthFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flRoot, AuthFragment())
            .commit()
    }

    override fun openOrderScreenFragment(phoneNumber: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flRoot, OrderScreenFragment.newInstance(phoneNumber = phoneNumber))
            .addToBackStack("OrderScreenFragment")
            .commit()
    }
}