package com.example.cargoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cargoapp.mvvm.CargoRepository
import com.example.cargoapp.databinding.FragmentCargoAddBinding
import com.example.cargoapp.model.Cargo
import java.text.SimpleDateFormat
import java.util.*

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
        val currentDateTime = SimpleDateFormat("dd/M/yyyy")

        binding.buttonKaydet.setOnClickListener{
            var cargo:Cargo = Cargo (
                binding.editTextGonderenAdSoyad.text.toString(),
                binding.editTextGonderenTC.text.toString(),
                binding.editTextGonderenEmail.text.toString(),
                binding.editTextGondericiAdres.text.toString(),
                binding.editTextAliciAdSoyad.text.toString(),
                binding.editTextAliciTC.text.toString(),
                binding.editTextEmailAddress.text.toString(),
                binding.editTextAliciAdres.text.toString(),
                currentDateTime.format(Date()),
                currentDateTime.format(Date())

            )

            val repository = CargoRepository()
            repository.addCargo(cargo)
            clearEditTexts() // degisken tanımlandı

        }
    }

    private fun clearEditTexts() {
        binding.apply {
            editTextGonderenAdSoyad.text.clear()
            editTextGonderenTC.text.clear()
            editTextGonderenEmail.text.clear()
            editTextGondericiAdres.text.clear()
            editTextAliciAdSoyad.text.clear()
            editTextAliciTC.text.clear()
            editTextEmailAddress.text.clear()
            editTextAliciAdres.text.clear()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}