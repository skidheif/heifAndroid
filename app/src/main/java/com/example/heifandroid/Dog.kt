package com.example.heifandroid

import android.util.Log

class Dog : Animal() {
    override fun voice() {
        Log.d("KotlinLessonTwoHomework", "Wof-wof");
    }

    fun dogBites() {
        Log.d("KotlinLessonTwoHomework", "I'll bite you, grrrrrrr")
    }
}