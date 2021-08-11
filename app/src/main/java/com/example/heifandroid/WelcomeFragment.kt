package com.example.heifandroid

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.heifandroid.MainActivity.Companion.SHARED_PREF_NAME
import com.example.heifandroid.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFragmentBinding
    var sharePref: SharedPreferences =
        requireContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

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
            sharePref.edit().putBoolean("welcomeButtonClicked", true).apply()
        }
    }
}