package com.example.heifandroid

import android.util.Log

class HomeworkLessonOne {
    fun homeWork() {

        val randomNumber: Int = generateRandomNumber();
        Log.d("kotlinHomeworkOne", "Random number is - $randomNumber")

        val circleArea: Double = (Math.PI * (randomNumber * randomNumber))
        Log.d("kotlinHomeworkOne", "Circle area is - $circleArea")

        val squareArea: Int = randomNumber * randomNumber
        Log.d("kotlinHomeworkOne", "Square area is - $squareArea")

        when {
            circleArea > squareArea -> Log.d("kotlinHomeworkOne", "The area of the circle is greater than the area of the square")
            squareArea > circleArea -> Log.d("kotlinHomeworkOne", "The area of the square is greater than the area of the circle")
        }

    }

    private fun generateRandomNumber(): Int {
        val startRandomRange = 1
        val endRandomRange = 10
        return (startRandomRange..endRandomRange).random()
    }
}