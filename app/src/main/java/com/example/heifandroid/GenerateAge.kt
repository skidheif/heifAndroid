package com.example.heifandroid

class GenerateAge {
    companion object {
        fun generateRandomAge(): Int {
            val startRandomRange = 1
            val endRandomRange = 100
            return (startRandomRange..endRandomRange).random()
        }
    }
}