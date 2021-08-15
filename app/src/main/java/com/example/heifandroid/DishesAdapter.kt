package com.example.heifandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heifandroid.databinding.ItemDishBinding

class DishesAdapter(val dishes: List<Dish>, val manager: FragmentManager) :
    RecyclerView.Adapter<DishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
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
        if (dishes[position].price == 235)
            holder.binding.root.setOnClickListener {
                openFoodItemInfoFragmentFirst()
            }
    }

    fun openFoodItemInfoFragmentFirst() {
        manager.beginTransaction()
            .show(FoodItemInfoFragmentFirst())
            .commit()
    }
}