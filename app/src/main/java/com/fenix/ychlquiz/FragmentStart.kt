package com.fenix.ychlquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fenix.ychlquiz.databinding.FragmentStartBinding


class FragmentStart : Fragment() {

    private lateinit var binding:FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.fragmentQuestion)
        }

        return binding.root
    }


}