package com.example.heifandroid

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val foodFragments: MutableList<Fragment> = mutableListOf()

    fun addFoodFragment(fragment: Fragment) {
        foodFragments.add(fragment)
    }

    override fun getItemCount(): Int {
        return foodFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return foodFragments[position]
    }
}