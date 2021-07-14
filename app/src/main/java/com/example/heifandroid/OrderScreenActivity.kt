package com.example.heifandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class OrderScreenActivity : AppCompatActivity() {

    companion object {
        const val PHONE_NUMBER_KEY = "PHONE_NUMBER"

        fun newInstance(activity: AuthActivity, phoneNumber: String) {
            val myIntent = Intent(activity, OrderScreenActivity::class.java)
            myIntent.putExtra(PHONE_NUMBER_KEY, phoneNumber)
            activity.startActivity(myIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_screen)
        val tvPhoneNumber = findViewById<TextView>(R.id.tvPhoneNumber)
        tvPhoneNumber.text =
            "Phone number from auth screen is:" + intent.getStringExtra(PHONE_NUMBER_KEY)
    }
}