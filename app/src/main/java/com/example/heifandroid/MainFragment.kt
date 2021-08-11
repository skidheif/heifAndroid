package com.example.heifandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.heifandroid.databinding.MainFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding
    lateinit var vpMainFirst: ViewPager2
    lateinit var vpMainSecond: ViewPager2
    lateinit var btvMain: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpMainFirst.adapter = ViewPagerAdapter(this).apply {
            addFoodFragment(FoodItemFragmentFirst())
            addFoodFragment(FoodItemFragmentSecond())
            addFoodFragment(FoodItemFragmentThird())
        }
        vpMainFirst.isUserInputEnabled = false

        binding.vpMainSecond.adapter = ViewPagerAdapter(this).apply {
            addFoodFragment(FoodItemFragmentThird())
            addFoodFragment(FoodItemFragmentSecond())
            addFoodFragment(FoodItemFragmentFirst())
        }
        vpMainSecond.isUserInputEnabled = false

        val foodTabNames = listOf("Всё", "Фаст-фуд", "Десерты")

        TabLayoutMediator(binding.tbMain, vpMainFirst) { tab, position ->
            tab.text = foodTabNames[position]
        }.attach()

        TabLayoutMediator(binding.tbMain, vpMainSecond) { tab, position ->
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