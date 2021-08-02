package com.example.cargoapp.LoginRegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cargoapp.R
import com.example.cargoapp.databinding.FragmentLoginBinding



class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()
        return view
    }

    private fun mainFunc() {
        binding.signInButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}