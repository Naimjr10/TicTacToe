package com.nandro.tictactoe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.databinding.FragmentMainMenuBinding
import com.nandro.tictactoe.tag.MainMenuFragment_TAG

class MainMenuFragment : Fragment() {
    var binding: FragmentMainMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(MainMenuFragment_TAG, "onCreateView()")

        // Inflate layout
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        Log.i(MainMenuFragment_TAG, "binding = $binding")
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(MainMenuFragment_TAG, "onViewCreated()")

        binding!!.pVsPButton.setOnClickListener {
            it as AppCompatButton
            Log.i(MainMenuFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            // Navigate to GameSettingFragment
            findNavController().navigate(R.id.action_mainMenuFragment_to_pvp_gameSettingFragment)
        }

        binding!!.pVsComButton.setOnClickListener {
            it as AppCompatButton
            Log.i(MainMenuFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            // Toast coming soon
            Toast.makeText(context, "Coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainMenuFragment_TAG, "onDestroy()")

        binding = null
        Log.i(MainMenuFragment_TAG, "binding = $binding")
    }

}