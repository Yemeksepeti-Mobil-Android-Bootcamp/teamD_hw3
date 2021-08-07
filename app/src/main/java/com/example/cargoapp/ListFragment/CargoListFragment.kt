package com.example.cargoapp.ListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cargo.CargoRecyclerViewAdapter
import com.example.cargoapp.MVVM.CargoRepository
import com.example.cargoapp.databinding.FragmentCargoListBinding

class CargoListFragment: Fragment() {
    private var _binding: FragmentCargoListBinding? = null
    private var adapter: CargoRecyclerViewAdapter = CargoRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCargoListBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        initViews()
        setData()
        return view
    }

    private fun setData() {
        val repository = CargoRepository()
        repository.getCargos(){
            adapter.setCargoList(it)
        }
    }

    private fun initViews() {
        _binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding!!.recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        setData()
    }
}