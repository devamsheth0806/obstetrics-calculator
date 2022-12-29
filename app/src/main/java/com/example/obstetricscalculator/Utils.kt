package com.example.obstetricscalculator

import kotlin.jvm.internal.DefaultConstructorMarker
import kotlin.jvm.internal.Intrinsics

object Utils {
    private var themeFlag = true
    fun getThemeFlag(): Boolean {
        return themeFlag
    }

    fun setThemeFlag(z: Boolean) {
        themeFlag = z
    }

    fun changeTheme(activity: MainActivity?) {
        val sharedPreferences = activity?.baseContext?.getSharedPreferences("Theme", 0)
        sharedPreferences?.let { setThemeFlag(it.getBoolean("flag", true)) }
        val edit = sharedPreferences?.edit()
        edit?.putBoolean("flag", true xor getThemeFlag())
        edit?.apply()
        activity?.recreate()
    }

}