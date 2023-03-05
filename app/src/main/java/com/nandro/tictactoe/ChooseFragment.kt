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
import kotlin.properties.Delegates

class ChooseFragment : Fragment() {
lateinit var binding: FragmentChooseBinding

companion object {
    var circleIsSelectedFirst = false
    var crossIsSelectedFirst = false
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChooseBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.circleRadio.setOnClickListener {
//            Toast.makeText(activity, "Circle first", Toast.LENGTH_SHORT).show()
            circleIsSelectedFirst = true
            crossIsSelectedFirst = false
        }

        binding.crossRadio.setOnClickListener {
//            Toast.makeText(activity, "Cross first", Toast.LENGTH_SHORT).show()
            crossIsSelectedFirst = true
            circleIsSelectedFirst = false
        }

        binding.playButton.setOnClickListener {
            if (crossIsSelectedFirst || circleIsSelectedFirst) {
                findNavController().navigate(R.id.action_chooseFragment_to_gameFragment)
            } else {
                Toast.makeText(activity, "Please select at least one", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

/*
    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(activity, "I got destroyed", Toast.LENGTH_SHORT).show()
        circleIsSelectedFirst = false
        crossIsSelectedFirst = false
    }
 */

}