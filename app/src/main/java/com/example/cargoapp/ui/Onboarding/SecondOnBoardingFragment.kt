package com.example.cargoapp.ui.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cargoapp.databinding.FragmentSecondOnBoardingBinding

class SecondOnBoardingFragment : Fragment() {
    private var _binding: FragmentSecondOnBoardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondOnBoardingBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()

        return view
    }

    private fun mainFunc() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}