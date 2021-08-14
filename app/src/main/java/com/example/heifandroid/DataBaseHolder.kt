package com.example.heifandroid

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import com.example.heifandroid.DataBaseHelper.Companion.DATABASE_NAME

class DataBaseHolder {

    companion object {
        lateinit var instance: SQLiteDatabase
        fun initDatabase(context: Context) {
            instance = context.openOrCreateDatabase(
                DATABASE_NAME,
                AppCompatActivity.MODE_PRIVATE, null
            )
        }
    }
}