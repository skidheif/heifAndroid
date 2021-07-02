package com.example.heifandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomNumber: Int = generateRandomNumber();
        Log.d("kotlinHomeworkOne", "Random number is - $randomNumber")

        val circleArea: Int = (Math.PI * (randomNumber * randomNumber)).toInt()
        Log.d("kotlinHomeworkOne", "Circle area is - $circleArea")

        val squareArea: Int = randomNumber * randomNumber
        Log.d("kotlinHomeworkOne", "Square area is - $squareArea")

        when {
            circleArea > squareArea -> Log.d("kotlinHomeworkOne", "The area of the circle is greater than the area of the square")
            squareArea > circleArea -> Log.d("kotlinHomeworkOne", "The area of the square is greater than the area of the circle")
        }

    }

    private fun generateRandomNumber(): Int {
        val startRandomRange: Int = 0
        val endRandomRange: Int = 10;
        return (startRandomRange..endRandomRange).random()
    }
}