package com.example.cargoapp.ListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cargo.CargoRecyclerViewAdapter
import com.example.cargo.OnCargoListener
import com.example.cargoapp.MVVM.CargoRepository
import com.example.cargoapp.MainFragmentDirections
import com.example.cargoapp.R
import com.example.cargoapp.databinding.FragmentCargoListBinding
import com.example.cargoapp.model.Cargo

class CargoListFragment: Fragment() ,OnCargoListener {
    private var _binding: FragmentCargoListBinding? = null
    private var adapter: CargoRecyclerViewAdapter = CargoRecyclerViewAdapter()
    private  lateinit var cargoList:List<Cargo>

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
            cargoList = it
            adapter.setCargoList(it,this)
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
    
    override fun OnCargoClick(position: Int) {
        val cargoItem:Cargo = cargoList.get(position)
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(cargoItem)
        findNavController().navigate(action)
    }
}