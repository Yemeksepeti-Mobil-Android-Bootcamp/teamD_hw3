package com.example.cargoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cargoapp.MVVM.CargoRepository
import com.example.cargoapp.databinding.FragmentCargoAddBinding
import com.example.cargoapp.databinding.FragmentSplashBinding
import com.example.cargoapp.model.Cargo

class CargoAddFragment : Fragment() {

    private var _binding: FragmentCargoAddBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCargoAddBinding.inflate(inflater, container, false)
        val view = binding.root

        mainFunc()
        return view
    }

    private fun mainFunc() {
        binding.buttonKaydet.setOnClickListener{
            var cargo:Cargo = Cargo("oktay","11111111111","oktyagca@gmail.com",
                "ankara","kaan","4444444444","kadirkaansarikaya@gmail.com",
                "Eskişehir")

            val repository = CargoRepository()
            repository.addCargo(cargo)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}