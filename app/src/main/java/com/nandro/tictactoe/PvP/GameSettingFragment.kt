package com.nandro.tictactoe.PvP

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameSettingBinding

class GameSettingFragment : Fragment() {
    companion object GameSetting {
        var firstPlay = MutableLiveData("")
        var player1CharGame = ""
        var player2CharGame = ""
        const val CROSS_CHAR = "Cross"
        const val CIRCLE_CHAR = "Circle"
        const val PLAYER_1 = "Player 1"
        const val PLAYER_2 = "Player 2"
    }

    var binding: FragmentPvpGameSettingBinding? = null

    //lateinit var viewModel: GameSettingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("GameSettingFragment", "created")
        //val viewModelFactory = ViewModelProvider.NewInstanceFactory()
        //viewModel = ViewModelProvider(requireActivity() as AppCompatActivity).get(GameSettingViewModel::class.java)
        Log.d("parentFragment","$parentFragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPvpGameSettingBinding.inflate(inflater, container, false)

        firstPlay?.observe(requireActivity()) {
            binding!!.chooseCharText.text = "Please, Choose your character \n$it"
        }

        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        makeWhoFirstViewsVisible()
        makeChooseCharViewslittleVisible()

        binding!!.confirmButton.setOnClickListener {
            
            if (firstPlay!!.value != "") {
                makeWhoFirstViewslittleVisible()
                makeChooseCharViewsVisible()

                if (player1CharGame != "" && player2CharGame != "") {
                    findNavController().navigate(R.id.action_gameSettingFragment_to_gameplayFragment)
                }
            } else {
                Toast.makeText(context,"Please, choose who play first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun makeWhoFirstViewslittleVisible() {
        binding!!.whoFirstText.alpha = 0.1F
        binding!!.whoFirstRadioGroup.alpha = 0.1F
        binding!!.p1RadioButton.isClickable = false
        binding!!.p2RadioButton.isClickable = false
    }

    private fun makeWhoFirstViewsVisible() {
        binding!!.whoFirstText.alpha = 1F
        binding!!.whoFirstRadioGroup.alpha = 1F

        binding!!.p1RadioButton.setOnClickListener {
            firstPlay!!.value = PLAYER_1
            Log.d("P1RadioButton", "clickable")
        }
        binding!!.p2RadioButton.setOnClickListener{
            firstPlay!!.value = PLAYER_2
            Log.d("P2RadioButton", "clickable")
        }
    }

    private fun makeChooseCharViewslittleVisible() {
        binding!!.chooseCharText.alpha = 0.1F
        binding!!.imageAndRadioWrapper.alpha = 0.1F
        binding!!.circleRadioButton.isClickable = false
        binding!!.crossRadioButton.isClickable = false

    }

    private fun makeChooseCharViewsVisible() {
        binding!!.chooseCharText.alpha = 1F
        binding!!.imageAndRadioWrapper.alpha = 1F
        binding!!.circleRadioButton.setOnClickListener {
            if (firstPlay!!.value == PLAYER_1) {
                player1CharGame = CIRCLE_CHAR
                player2CharGame = CROSS_CHAR
            }
            if (firstPlay!!.value == PLAYER_2) {
                player2CharGame = CIRCLE_CHAR
                player1CharGame = CROSS_CHAR
            }
        }
        binding!!.crossRadioButton.setOnClickListener {
            if (firstPlay!!.value == PLAYER_1) {
                player1CharGame = CROSS_CHAR
                player2CharGame = CIRCLE_CHAR
            }
            if (firstPlay!!.value == PLAYER_2) {
                player2CharGame = CROSS_CHAR
                player1CharGame = CIRCLE_CHAR
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GameSettingFragment", "destroyed")
        firstPlay.removeObservers(requireActivity())
    }

}