package com.example.hiltwithretrofit.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltwithretrofit.databinding.EmployeeItemBinding
import com.example.hiltwithretrofit.others.ResultPokemon
import javax.inject.Inject

class EmployeeAdapter @Inject constructor(): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(){

    private val diffCallback = object : DiffUtil.ItemCallback<ResultPokemon>(){
        override fun areItemsTheSame(oldItem: ResultPokemon, newItem: ResultPokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: ResultPokemon, newItem: ResultPokemon): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this,diffCallback)

    fun submitList(list: List<ResultPokemon>) = differ.submitList(list)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int): Unit = with(holder){
        val item = differ.currentList[position]
        itemView.apply {
            tvName.text = "${item.name}"
            tvSalary.text = "Salary: Rs.${item.url}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
       // context = parent.context
        val binding = EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }


    class EmployeeViewHolder(binding: EmployeeItemBinding):RecyclerView.ViewHolder(binding.root){
        val tvName = binding.tvName
        val tvSalary = binding.tvSalary
        val tvAge = binding.tvAge
    }
}