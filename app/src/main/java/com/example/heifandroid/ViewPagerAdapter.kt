package com.example.heifandroid

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

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