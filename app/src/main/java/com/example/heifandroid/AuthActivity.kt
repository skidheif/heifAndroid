package com.example.heifandroid

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    companion object {
        const val TAG = "ActivityHomeWork"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_screen)

        val btnBegin = findViewById<Button>(R.id.btnBegin)
        btnBegin.setOnClickListener {
            val phoneNumberFromEditText =
                findViewById<EditText>(R.id.etAuthPhoneMask).text.toString()
            Log.d(TAG, "Button 'НАЧАТЬ' clicked")
            OrderScreenActivity.newInstance(activity = this, phoneNumberFromEditText)
        }
    }
}