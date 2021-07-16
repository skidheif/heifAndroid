package com.example.heifandroid

import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.heifandroid.databinding.ActivityMainBinding
import com.example.heifandroid.databinding.FragmentAuthScreenBinding
import com.github.pinball83.maskededittext.MaskedEditText

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureBeginBtn()
    }

    private fun configureBeginBtn() {
        binding.btnBegin.setOnClickListener {
            (activity as Navigation).openOrderScreenFragment(binding.etAuthPhone.text.toString())
        }
    }
}