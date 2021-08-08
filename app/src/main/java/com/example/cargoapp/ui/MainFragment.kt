package com.example.cargoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.cargoapp.R
import com.example.cargoapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MainFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        setViewPager()
        setBottomNavi()
        return view
    }

    private fun setBottomNavi() {

        binding.bottomNavigation.apply {
            add(MeowBottomNavigation.Model(0, R.drawable.ic_baseline_add_box_24))
            add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_format_list_bulleted_24))
            add(MeowBottomNavigation.Model(2, R.drawable.ic_baseline_settings_24))
        }
        binding.bottomNavigation.show(1)

        binding.bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0->{
                    binding.viewPager2.currentItem = 0
                }
                1->{
                    binding.viewPager2.currentItem = 1
                }
                2->{
                    binding.viewPager2.currentItem = 2
                }
                else ->{
                    binding.viewPager2.currentItem = 1
                }
            }

        }
    }

    private fun setViewPager() {
        adapter = MainFragmentAdapter(requireActivity())
        binding.viewPager2.isUserInputEnabled = false
        binding.viewPager2.adapter = adapter
        binding.viewPager2.currentItem = 1

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}