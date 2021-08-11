package com.example.heifandroid

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFoodFragmentFirst()
    }


    private fun openFoodFragmentFirst() {
        val btnWelcomeBegin = findViewById<Button>(R.id.btnWelcomeBegin)
        btnWelcomeBegin.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.clMain, MainFragment())
                .commit()
        }
    }
}