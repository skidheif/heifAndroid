package com.example.heifandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var vpMainFirst: ViewPager2
    lateinit var vpMainSecond: ViewPager2
    lateinit var btvMain: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpMainFirst = findViewById(R.id.vpMainFirst)
        vpMainSecond = findViewById(R.id.vpMainSecond)
        btvMain = findViewById(R.id.btvMain)

        vpMainFirst.adapter = ViewPagerAdapter(this).apply {
            addFoodFragment(FoodItemFragmentFirst())
            addFoodFragment(FoodItemFragmentSecond())
            addFoodFragment(FoodItemFragmentThird())
        }
        vpMainFirst.isUserInputEnabled = false

        vpMainSecond.adapter = ViewPagerAdapter(this).apply {
            addFoodFragment(FoodItemFragmentThird())
            addFoodFragment(FoodItemFragmentSecond())
            addFoodFragment(FoodItemFragmentFirst())
        }
        vpMainSecond.isUserInputEnabled = false

        val foodTabNames = listOf("Всё", "Фаст-фуд", "Десерты")
        val tbMain = findViewById<TabLayout>(R.id.tbMain)

        TabLayoutMediator(tbMain, vpMainFirst) { tab, position ->
            tab.text = foodTabNames[position]
        }.attach()

        TabLayoutMediator(tbMain, vpMainSecond) { tab, position ->
            tab.text = foodTabNames[position]
        }.attach()

        btvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itMenu -> {
                    vpMainFirst.visibility = View.VISIBLE
                    vpMainSecond.visibility = View.INVISIBLE;
                    vpMainFirst.currentItem = 0
                }
                R.id.itFavourite -> {
                    vpMainSecond.currentItem = 0
                    vpMainFirst.visibility = View.INVISIBLE
                    vpMainSecond.visibility = View.VISIBLE;
                }
            }
            true
        }
    }
}