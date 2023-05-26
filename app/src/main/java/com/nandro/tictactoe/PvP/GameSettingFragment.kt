package com.nandro.tictactoe.PvP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.widget.AppCompatImageView
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameSettingBinding

class GameSettingFragment : Fragment() {
    var binding: FragmentPvpGameSettingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPvpGameSettingBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.chooseCharText.setOnClickListener {
            binding!!.whoFirstText.alpha = 0.1F
            binding!!.whoFirstRadioGroup.alpha = 0.1F

            binding!!.chooseCharText.alpha = 1F
            binding!!.imageAndRadioWrapper.alpha = 1F
        }
    }

}