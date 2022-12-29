package com.example.obstetricscalculator

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(activity: Fragment) : FragmentStateAdapter(activity) {
//    val itemCount: Int = NUMBER_OF_FRAGMENTS

    override fun getItemCount(): Int {
        return NUMBER_OF_FRAGMENTS
    }

    override fun createFragment(i: Int): Fragment {
        if (i != 0) {
            if (i == 1) {
                return USGAge()
            }
            throw IllegalStateException("Invalid Position")
        }
        return GestationalAge()
    }

    companion object {
        const val GESTATIONAL_AGE_POSITION = 0
        const val NUMBER_OF_FRAGMENTS = 2
        const val USG_AGE_POSITION = 1
    }
}