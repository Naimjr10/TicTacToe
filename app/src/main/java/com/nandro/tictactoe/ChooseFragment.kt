package com.nandro.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.databinding.FragmentChooseBinding

class ChooseFragment : Fragment() {
lateinit var binding: FragmentChooseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChooseBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.circleRadio.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.crossRadio.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_chooseFragment_to_gameFragment)
        }

        return view
    }

}