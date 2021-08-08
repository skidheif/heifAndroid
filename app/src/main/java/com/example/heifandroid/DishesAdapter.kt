package com.example.heifandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.heifandroid.databinding.ItemDishBinding

class DishesAdapter(val dishes: List<Dish>) : RecyclerView.Adapter<DishViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(ItemDishBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.binding.ivDishPhoto.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemView.context, dishes[position].image
            )
        )
        with(holder.binding) {
            tvDishTitle.text = dishes[position].name
            tvDishDescription.text = dishes[position].description
            tvDishPrice.text = dishes[position].price.toString() + " ₽"
        }
    }
}