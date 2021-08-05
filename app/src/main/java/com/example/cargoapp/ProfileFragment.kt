package com.example.cargoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.cargoapp.MVVM.CargoRepository
import com.example.cargoapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment: Fragment() {

        private var _binding: FragmentProfileBinding? = null
        private val binding get() = _binding!!
        private lateinit var auth: FirebaseAuth

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentProfileBinding.inflate(inflater, container, false)
            val view = binding.root
            mainFunc()
            return view
        }

    private fun mainFunc() {
        val auth = FirebaseAuth.getInstance()
        val repository = CargoRepository()
        var user = repository.getCurrentUser()
        user=auth.currentUser
        binding.apply {
            if (user != null) {
                name.text = user.displayName
                mail.text = user.email
                Glide.with(imageView.context)
                    .load(user.photoUrl).into(imageView);
                if(user.phoneNumber !=null) {
                    phone.text = user.phoneNumber
                }
                else{
                    phone.text = "Telefon bilgisi eksik"
                }
            }
        }

        binding.logout.setOnClickListener{
            auth.signOut()
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }


}