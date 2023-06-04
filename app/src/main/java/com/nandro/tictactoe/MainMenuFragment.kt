package com.nandro.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {
    var binding: FragmentMainMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.pVsPButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainMenuFragment_to_gameSettingFragment)
        }

        binding!!.pVsComButton.setOnClickListener {
            Toast.makeText(requireActivity(), "Coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}