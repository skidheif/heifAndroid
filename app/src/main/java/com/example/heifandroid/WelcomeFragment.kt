package com.example.heifandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.heifandroid.SharedPrefHelper.Companion.SP_WELCOME_BUTTON_CLICKED
import com.example.heifandroid.SharedPrefHelper.Companion.putBoolean
import com.example.heifandroid.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureWelcomeBeginBtn()
        configureButtonDontShow()
    }

    private fun configureWelcomeBeginBtn() {
        binding.btnWelcomeBegin.setOnClickListener {
            (activity as Navigation).openFoodFragmentFirst()
        }
    }

    private fun configureButtonDontShow() {
        binding.tvWelcomeDontShowAgain.setOnClickListener {
            putBoolean(SP_WELCOME_BUTTON_CLICKED, true)
            (activity as Navigation).openFoodFragmentFirst()
        }
    }
}