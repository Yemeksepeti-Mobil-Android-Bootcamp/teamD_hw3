package com.example.cargoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cargoapp.databinding.FragmentDetailBinding

class DetailFragment:Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    val args:DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        initViews()
        return view
    }

    private fun initViews() {
        binding.senderName.text = args.corgoItem.senderName
        binding.senderTc.text = args.corgoItem.senderTc
        binding.senderMail.text = args.corgoItem.senderMail
        binding.senderDate.text = args.corgoItem.sendDate
        binding.senderAddress.text = args.corgoItem.senderAddress
        binding.receiverName.text = args.corgoItem.receiverName
        binding.receiverMail.text = args.corgoItem.receiverMail
        binding.receiverDate.text = args.corgoItem.receiveDate
        binding.receiverAddress.text = args.corgoItem.receiverAddress
    }


}