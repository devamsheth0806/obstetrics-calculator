package com.example.obstetricscalculator

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(bundle: Bundle?) {
        setThemeCustom()
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)
    }

    private fun setThemeCustom() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Theme", 0)
        if (sharedPreferences.getBoolean("flag", true)) {
            setTheme(com.google.android.material.R.style.Theme_Material3_Light)
        } else {
            setTheme(com.google.android.material.R.style.Theme_Material3_Dark)
        }
    }
}