package com.example.cargoapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cargoapp.ui.ListFragment.CargoListFragment


private const val FRAGMENT_COUNT = 3

class MainFragmentAdapter(requireActivity: FragmentActivity) : FragmentStateAdapter(requireActivity) {

    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CargoAddFragment()
            1 -> CargoListFragment()
            2 -> ProfileFragment()
            else -> CargoAddFragment()
        }
    }
}