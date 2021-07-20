package com.example.heifandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.heifandroid.databinding.FragmentOrderScreenBinding

class OrderScreenFragment : Fragment() {

    companion object {
        const val PHONE_NUMBER_KEY = "PHONE_NUMBER"

        fun newInstance(phoneNumber: String): OrderScreenFragment {
            return OrderScreenFragment().apply {
                arguments = bundleOf(PHONE_NUMBER_KEY to phoneNumber)
            }
        }
    }

    private var phoneNumber: String? = null
    private lateinit var binding: FragmentOrderScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        phoneNumber = arguments?.getString(PHONE_NUMBER_KEY)
        binding.tvPhoneNumber.text = "Phone number: $phoneNumber"
        configureFoodItemInfoClick()
    }

    private fun configureFoodItemInfoClick() {
        binding.clFoodItem.setOnClickListener {
            FoodItemInfoFragment().show(childFragmentManager, "FoodItemInfoFragment")
        }
    }
}