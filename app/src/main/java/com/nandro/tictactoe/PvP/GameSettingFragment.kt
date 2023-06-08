package com.nandro.tictactoe.pvp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameSettingBinding
import com.nandro.tictactoe.tag.GameSettingFragment_pvp_TAG

class GameSettingFragment : Fragment() {
    companion object {
        const val FIRST_PLAY_KEY = "firstPlay_KEY"
        const val PLAYER1_CHAR_GAME_KEY = "player1CharGame_KEY"
        const val PLAYER2_CHAR_GAME_KEY = "player2CharGame_KEY"
    }

    private var firstPlay = MutableLiveData("")
    private var player1CharGame = ""
    private var player2CharGame = ""

    private var binding: FragmentPvpGameSettingBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(GameSettingFragment_pvp_TAG, "onCreate()")

        // Implement custom BACK Navigation
        val callBack = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.i(GameSettingFragment_pvp_TAG, "handleOnBackPressed()")

                firstPlay.value = ""
                Log.i(GameSettingFragment_pvp_TAG, "firstPlay.value = ${firstPlay.value}")
                player1CharGame = ""
                Log.i(GameSettingFragment_pvp_TAG, "player1CharGame = ${player1CharGame}")
                player2CharGame = ""
                Log.i(GameSettingFragment_pvp_TAG, "player2CharGame = ${player2CharGame}")

                // Navigate back to MainMenuFragment
                findNavController().popBackStack()
            }
        }
        // Apply the custom BACK Navigation only to this activity ( GameSettingFragment )
        requireActivity().onBackPressedDispatcher.addCallback(this, callBack)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(GameSettingFragment_pvp_TAG, "onCreateView()")

        // Inflate layout
        binding = FragmentPvpGameSettingBinding.inflate(inflater, container, false)
        Log.i(GameSettingFragment_pvp_TAG, "binding = $binding")

        // Observe the firstPlay value and update chooseCharText text immediately
        // when the value changes
        firstPlay.observe(requireActivity()) {
            Log.i(GameSettingFragment_pvp_TAG, "firstPlay.observe()")

            binding!!.chooseCharText.text = "Please, Choose your character \n$it"
        }

        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(GameSettingFragment_pvp_TAG, "onViewCreated()")

        makeWhoFirstViews_Visible()
        makeChooseCharViews_littleVisible()

        binding!!.confirmButton.setOnClickListener {
            it as AppCompatButton
            Log.i(GameSettingFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            // Check whether the first to play has been determined
            if (firstPlay.value != "") {
                makeWhoFirstViews_littleVisible()
                makeChooseCharViews_Visible()

                // Check whether the first player has selected character
                if (player1CharGame != "" && player2CharGame != "") {
                    val bundle = Bundle().apply {
                        putString(FIRST_PLAY_KEY, firstPlay.value)
                        putString(PLAYER1_CHAR_GAME_KEY, player1CharGame)
                        putString(PLAYER2_CHAR_GAME_KEY, player2CharGame)
                    }
                    findNavController().navigate(
                        R.id.action_pvp_gameSettingFragment_to_pvp_gameplayFragment,
                        bundle)
                }
            } else {
                Toast.makeText(context, "Please, choose who play first", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun makeWhoFirstViews_littleVisible() {
        Log.i(GameSettingFragment_pvp_TAG, "makeWhoFirstViews_littleVisible()")

        binding!!.whoFirstText.alpha = 0.1F
        binding!!.whoFirstRadioGroup.alpha = 0.1F
        binding!!.p1RadioButton.isClickable = false
        binding!!.p2RadioButton.isClickable = false

    }

    private fun makeWhoFirstViews_Visible() {
        Log.i(GameSettingFragment_pvp_TAG, "makeWhoFirstViews_Visible()")

        binding!!.whoFirstText.alpha = 1F
        binding!!.whoFirstRadioGroup.alpha = 1F

        binding!!.p1RadioButton.setOnClickListener {
            it as RadioButton
            firstPlay.value = PLAYER_1
            Log.i(GameSettingFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")
        }
        binding!!.p2RadioButton.setOnClickListener {
            it as RadioButton
            firstPlay.value = PLAYER_2
            Log.i(GameSettingFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")
        }

    }

    private fun makeChooseCharViews_littleVisible() {
        Log.i(GameSettingFragment_pvp_TAG, "makeChooseCharViews_littleVisible()")

        binding!!.chooseCharText.alpha = 0.1F
        binding!!.imageAndRadioWrapper.alpha = 0.1F
        binding!!.circleRadioButton.isClickable = false
        binding!!.crossRadioButton.isClickable = false
    }

    private fun makeChooseCharViews_Visible() {
        Log.i(GameSettingFragment_pvp_TAG, "makeChooseCharViews_Visible()")

        binding!!.chooseCharText.alpha = 1F
        binding!!.imageAndRadioWrapper.alpha = 1F

        binding!!.circleRadioButton.setOnClickListener {
            Log.i(GameSettingFragment_pvp_TAG, "${it.contentDescription} clicked")

            if (firstPlay.value == PLAYER_1) {
                player1CharGame = CIRCLE_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player1CharGame = $player1CharGame")

                player2CharGame = CROSS_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player2CharGame = $player2CharGame")
            }
            if (firstPlay.value == PLAYER_2) {
                player2CharGame = CIRCLE_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player2CharGame = $player2CharGame")

                player1CharGame = CROSS_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player1CharGame = $player1CharGame")
            }
        }
        binding!!.crossRadioButton.setOnClickListener {
            Log.i(GameSettingFragment_pvp_TAG, "${it.contentDescription} clicked")

            if (firstPlay.value == PLAYER_1) {
                player1CharGame = CROSS_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player1CharGame = $player1CharGame")

                player2CharGame = CIRCLE_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player2CharGame = $player2CharGame")
            }
            if (firstPlay.value == PLAYER_2) {
                player2CharGame = CROSS_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player2CharGame = $player2CharGame")

                player1CharGame = CIRCLE_CHAR
                Log.i(GameSettingFragment_pvp_TAG, "player1CharGame = $player1CharGame")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(GameSettingFragment_pvp_TAG, "onDestroyView()")

        binding = null
        Log.i(GameSettingFragment_pvp_TAG, "binding = $binding")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(GameSettingFragment_pvp_TAG, "onDestroy()")

        firstPlay.removeObservers(requireActivity())
    }

}