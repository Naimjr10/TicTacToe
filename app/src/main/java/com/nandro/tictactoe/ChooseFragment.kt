package com.nandro.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.get
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.databinding.FragmentChooseBinding
import kotlin.properties.Delegates

class ChooseFragment : Fragment() {
    private var binding: FragmentChooseBinding? = null

    companion object {
        var isCircleFirst: Boolean? = null
        var isCrossFirst: Boolean? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChooseBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.circleRadio.setOnClickListener {
            isCircleFirst = true
            isCrossFirst = false
        }

        binding!!.crossRadio.setOnClickListener {
            isCrossFirst = true
            isCircleFirst = false
        }

        binding!!.playButton.setOnClickListener {
            if (isCircleFirst != null || isCrossFirst != null) {
                findNavController().navigate(R.id.action_chooseFragment_to_gameFragment)
            } else {
                Toast.makeText(context,"Please select at least one", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}