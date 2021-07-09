package com.example.heifandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "KotlinLessonThreeHomework"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person: MutableList<Person> = mutableListOf()
        for (i in 1..15) {
            person.add(
                i - 1, Person(
                    GenerateRussianName.chooseRandomName(),
                    GenerateAge.generateRandomAge()
                )
            )
        }

        Log.d(TAG, "Print all persons with name and age")
        person.forEach { Log.d(TAG, "Person name is ${it.name}, person age is - ${it.age}") }
        Log.d(TAG, " ")

        Log.d(TAG, "Print first person from list, whose age is over 70 years old")
        val oldPerson = person.find { it.age > 70 }
        Log.d(TAG, "onCreate: ${oldPerson?.name}")
        Log.d(TAG, " ")

        Log.d(TAG, "Print all person from list, whose age is over 20 but less then 50 years old")
        val filteredPersons: MutableList<Person> = mutableListOf()
        filteredPersons += person.filter { it.age > 20 && it.age < 50 }
        filteredPersons.forEach { Log.d(TAG, "Person name is ${it.name}, person age is - ${it.age}") }
    }
}