package com.example.cargoapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cargoapp.ui.Onboarding.FirstOnBoardingFragment
import com.example.cargoapp.ui.Onboarding.SecondOnBoardingFragment
import com.example.cargoapp.ui.Onboarding.ThirdOnBoardingFragment

private const val FRAGMENT_COUNT = 3

class OnboardingAdapter(requireActivity: FragmentActivity) : FragmentStateAdapter(requireActivity) {


    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstOnBoardingFragment()
            1 -> SecondOnBoardingFragment()
            2 -> ThirdOnBoardingFragment()
            else -> FirstOnBoardingFragment()
        }
    }

}