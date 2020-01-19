package com.example.a0shared_prefernce_checkbox

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedpreferences = getPreferences(Context.MODE_PRIVATE)
        checkBox.isChecked=sharedpreferences.getBoolean("check",false)

        button.setOnClickListener {
            val sharedpreferences = getPreferences(Context.MODE_PRIVATE)
            val editor = sharedpreferences.edit()
            editor.putBoolean("check",checkBox.isChecked)
            editor.apply()
        }
    }
}
