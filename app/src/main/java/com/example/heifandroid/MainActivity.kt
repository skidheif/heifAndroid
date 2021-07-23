package com.example.heifandroid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vpMain = findViewById<ViewPager2>(R.id.vpMain)
        vpMain.adapter = ViewPagerAdapter(this).apply {
            addFoodFragment(FoodItemFragmentFirst())
            addFoodFragment(FoodItemFragmentSecond())
            addFoodFragment(FoodItemFragmentThird())
        }

        val foodTabNames = listOf("Всё", "Фаст-фуд", "Десерты")
        val tbMain = findViewById<TabLayout>(R.id.tbMain)
        TabLayoutMediator(tbMain, vpMain) { tab, position ->
            tab.text = foodTabNames[position]
        }.attach()
    }
}