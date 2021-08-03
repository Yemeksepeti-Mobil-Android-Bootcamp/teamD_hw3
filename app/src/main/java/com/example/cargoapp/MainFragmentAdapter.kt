package com.example.cargoapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cargoapp.ListFragment.CargoListFragment
import com.example.cargoapp.Onboarding.FirstOnBoardingFragment
import com.example.cargoapp.databinding.FragmentMainBinding


private const val FRAGMENT_COUNT = 2

class MainFragmentAdapter(requireActivity: FragmentActivity) : FragmentStateAdapter(requireActivity) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->{
                CargoListFragment()
            }
            1 ->{
                CargoAddFragment()
            }
            else -> {
                FirstOnBoardingFragment()
            }
        }
    }

}