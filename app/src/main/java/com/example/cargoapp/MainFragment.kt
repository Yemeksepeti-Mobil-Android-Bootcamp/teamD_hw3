package com.example.cargoapp

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cargoapp.databinding.FragmentMainBinding
import com.example.cargoapp.databinding.FragmentSplashBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()
        return view
    }

    private fun mainFunc() {

        val adapter = MainFragmentAdapter(requireActivity())

        binding.viewPager2.adapter = adapter
        binding.wormDots.setViewPager2(binding.viewPager2)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}