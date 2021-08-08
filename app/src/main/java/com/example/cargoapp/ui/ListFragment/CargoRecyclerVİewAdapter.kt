package com.example.cargo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cargoapp.databinding.ItemCargoBinding
import com.example.cargoapp.model.Cargo

class CargoRecyclerViewAdapter:RecyclerView.Adapter<CargoRecyclerViewAdapter.CargoViewHolder>() {
    private lateinit var binding: ItemCargoBinding
    private lateinit var  onCargoListener :OnCargoListener
    private  var cargoList:List<Cargo> = mutableListOf()

    class CargoViewHolder(private val binding: ItemCargoBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        lateinit var  onCargoListener :OnCargoListener
        fun setItem(item: Cargo,onCargoListener: OnCargoListener) {
            this.onCargoListener = onCargoListener
            binding.senderTextView.text = item.senderName
            binding.receiverTextView.text = item.receiverName
            binding.arrivalDateTextView.text = item.receiveDate
            binding.destinationTextView.text = item.receiverAddress
            binding.firstPointTextView.text = item.senderAddress
            binding.releaseDateTextView.text = item.sendDate
            binding.button.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            onCargoListener.OnCargoClick(adapterPosition)
        }
    }

    fun setCargoList(cargoList: List<Cargo>,onCargoListener: OnCargoListener) {
        this.onCargoListener =onCargoListener
        this.cargoList = cargoList
        println(cargoList.size)
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
        holder.setItem(item,onCargoListener)
    }

    override fun getItemCount():Int  = cargoList.size
}

interface OnCargoListener{
     fun OnCargoClick(position:Int)
}