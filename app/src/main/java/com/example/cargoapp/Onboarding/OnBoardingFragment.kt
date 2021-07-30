package com.example.cargoapp.Onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cargoapp.OnboardingAdapter
import com.example.cargoapp.R
import com.example.cargoapp.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnBoardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()

        return view
    }

    private fun mainFunc() {
        val adapter = OnboardingAdapter(requireActivity())

        binding.viewPager2.adapter = adapter
        binding.wormDots.setViewPager2(binding.viewPager2)


        binding.cardViewButton.setOnClickListener {

            //Eğer son onboarding sayfasına geldiyse diye kontrol ediyoruz.
            if (binding.viewPager2.currentItem == adapter.itemCount-1) {
                onBoardingFinished()
                findNavController().navigate(R.id.action_onBoardingFragment_to_mainFragment)
            } else {
                binding.viewPager2.currentItem = binding.viewPager2.currentItem + 1
            }

        }
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("finished", true)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}