package com.nandro.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.databinding.FragmentGameBinding

class GameFragment : Fragment() {
lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.col1.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col2.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col3.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col4.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col5.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col6.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col7.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col8.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }

        binding.col9.setOnClickListener {
            Toast.makeText(activity, "I got clicked", Toast.LENGTH_SHORT).show()
        }


        binding.newGameButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_chooseFragment)
        }

        return view
    }


}