package com.example.heifandroid

interface Navigation {
    fun openAuthFragment()
    fun openOrderScreenFragment(phoneNumber: String)
}