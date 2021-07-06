package com.example.heifandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cat: Animal = Cat()
        val dog: Animal = Dog()

        cat.voice()
        dog.voice()

        val animals: Array<Animal> = arrayOf(cat, dog)

        for (animal in animals) {
            (animal as? Cat)?.catScratching()
            (animal as? Dog?)?.dogBites()
        }
    }
}