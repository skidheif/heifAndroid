package com.example.heifandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heifandroid.databinding.FoodItemFragmentFirstBinding

class FoodItemFragmentFirst : Fragment() {

    lateinit var binding: FoodItemFragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FoodItemFragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvDishes.adapter = DishesAdapter(generateDish())
        binding.rvDishes.layoutManager = LinearLayoutManager(requireContext())
        configureFoodItemInfoClick()
    }

    private fun configureFoodItemInfoClick() {
        binding.rvDishes.setOnClickListener {
//            FoodItemFragmentFirst().show(childFragmentManager, "FoodItemInfoFragment")
        }
    }

    private fun generateDish(): List<Dish> {
        return listOf(
            Dish(
                "Том Ям суп с\n" + "морепродуктами",
                "Бульон из пряного говяжьего \nмясного супа с кокосовым молок...",
                235, R.drawable.tom_yam_dish
            ),
            Dish(
                "Сет Филадельфия\n" + "Party De Luxe",
                "Лосось, огурец, авокадо, кунжут, \nсыр, зеленый лук, 6 шт",
                210, R.drawable.philadelfia_dish
            ),
            Dish(
                "Десерт круассан\n" + "с грецкими орехами",
                "Нежный бисквит с грецкими \nорехами и ноткой корицы, крем..",
                115, R.drawable.croissan_dish
            )
        )
    }
}