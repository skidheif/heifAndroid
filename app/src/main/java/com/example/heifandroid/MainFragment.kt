package com.example.heifandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.heifandroid.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding

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
        binding.vpMainFirst.isUserInputEnabled = false

        binding.vpMainSecond.adapter = ViewPagerAdapter(this).apply {
            addFoodFragment(FoodItemFragmentThird())
            addFoodFragment(FoodItemFragmentSecond())
            addFoodFragment(FoodItemFragmentFirst())
        }
        binding.vpMainSecond.isUserInputEnabled = false

        val foodTabNames = listOf("Всё", "Фаст-фуд", "Десерты")

        TabLayoutMediator(binding.tbMain, binding.vpMainFirst) { tab, position ->
            tab.text = foodTabNames[position]
        }.attach()

        TabLayoutMediator(binding.tbMain, binding.vpMainSecond) { tab, position ->
            tab.text = foodTabNames[position]
        }.attach()

        binding.btvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itMenu -> {
                    with(binding.vpMainFirst) {
                        visibility = View.VISIBLE
                        visibility = View.INVISIBLE;
                        currentItem = 0
                    }
                }
                R.id.itFavourite -> {
                    with(binding.vpMainSecond) {
                        currentItem = 0
                        visibility = View.INVISIBLE
                        visibility = View.VISIBLE
                    }
                }
            }
            true
        }
    }
}