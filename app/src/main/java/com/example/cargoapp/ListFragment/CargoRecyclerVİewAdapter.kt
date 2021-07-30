package com.example.cargo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cargoapp.ListFragment.Item
import com.example.cargoapp.databinding.ItemCargoBinding

class CargoRecyclerViewAdapter:RecyclerView.Adapter<CargoRecyclerViewAdapter.CargoViewHolder>() {
    private lateinit var binding: ItemCargoBinding
    private var cargoList = ArrayList<Item>()


    class CargoViewHolder(private val binding: ItemCargoBinding):RecyclerView.ViewHolder(binding.root){
        fun setItem(item: Item) {
            binding.senderTextView.text = item.sender
            binding.receiverTextView.text = item.receiver
            binding.arrivalDateTextView.text = item.arrivalDate
            binding.destinationTextView.text = item.destination
            binding.firstPointTextView.text = item.firstPoint
            binding.releaseDateTextView.text = item.releaseDate
        }
    }

    fun setFoodList(cargoList: ArrayList<Item>) {
        this.cargoList = cargoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CargoViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
        //return CargoViewHolder(view)
        binding = ItemCargoBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CargoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CargoViewHolder, position: Int) {
        val item = cargoList[position]
        holder.setItem(item)
    }

    override fun getItemCount():Int  = cargoList.size
}