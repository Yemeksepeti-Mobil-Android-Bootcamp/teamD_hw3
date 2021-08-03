package com.example.cargoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.cargoapp.databinding.FragmentMainBinding


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
        setBottomNavi()
        return view
    }

    private fun setBottomNavi() {
        binding.bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_baseline_format_list_bulleted_24))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_baseline_add_box_24))
        binding.bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_baseline_settings_24))
        binding.bottomNavigation.show(0)

        binding.bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0->{
                    Toast.makeText(this.context,"ListFragment",Toast.LENGTH_SHORT).show()
                    binding.viewPager2.currentItem = 0
                }
                1->{
                    Toast.makeText(this.context,"AddFragment",Toast.LENGTH_SHORT).show()
                    binding.viewPager2.currentItem = 1
                }
                2->{
                    Toast.makeText(this.context,"SettingFragment",Toast.LENGTH_SHORT).show()
                    binding.viewPager2.currentItem = 2
                }
                else ->{
                    Toast.makeText(this.context,"HomeFragment",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun mainFunc() {

        val adapter = MainFragmentAdapter(requireActivity())


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}