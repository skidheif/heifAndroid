package com.example.heifandroid

import android.util.Log

class Cat : Animal() {
    override fun voice() {
        Log.d("KotlinLessonTwoHomework", "Meow-meow");
    }

    fun catScratching() {
        Log.d("KotlinLessonTwoHomework", "I'll scratch you, shhhhhhh")
    }
}