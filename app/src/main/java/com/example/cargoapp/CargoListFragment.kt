package com.example.cargoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cargo.CargoRecyclerViewAdapter
import com.example.cargo.Item
import com.example.cargoapp.databinding.FragmentCargoListBinding
import com.example.cargoapp.databinding.FragmentSplashBinding

class CargoListFragment: Fragment() {
    private var _binding: FragmentCargoListBinding? = null
    private var adapter: CargoRecyclerViewAdapter = CargoRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCargoListBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        initViews()
        setData()
        return view
    }

    private fun setData() {
        val data = ArrayList<Item>()
        for (i in 0..100) {
            data.add(Item("Rancho Santa Margarita,CA $i", "Baja California,CA - $i",
                "Oktay Ağca $i","Kodluyoruz  $i","Jun 09, 13.40","Jun 09, 13.40"))
        }
        adapter.setFoodList(data)
    }

    private fun initViews() {

        _binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding!!.recyclerView.adapter = adapter
    }
}