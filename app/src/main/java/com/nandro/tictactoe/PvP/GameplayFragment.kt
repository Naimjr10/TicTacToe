package com.nandro.tictactoe.pvp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.customview.Column
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameplayBinding
import com.nandro.tictactoe.pvp.GameSettingFragment.GameSetting.player1CharGame
import com.nandro.tictactoe.pvp.GameSettingFragment.GameSetting.player2CharGame
import com.nandro.tictactoe.pvp.GameSettingFragment.GameSetting.firstPlay
import com.nandro.tictactoe.tag.GameplayFragment_TAG
import java.io.File

class GameplayFragment : Fragment() {
    private var binding: FragmentPvpGameplayBinding? = null
    private lateinit var onTurn: String
    private var theWinner = ""

    private lateinit var p1NumOfWins: String
    private lateinit var p1NumOfLoses: String
    private lateinit var p2NumOfWins: String
    private lateinit var p2NumOfLoses: String

    init {
        if (firstPlay.value == PLAYER_1) {
            onTurn = PLAYER_1
        }
        if (firstPlay.value == PLAYER_2) {
            onTurn = PLAYER_2
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(GameplayFragment_TAG, "onCreate()")

        createFiles() // Create files if the files don't exist
        readFiles() // Read the files

        // Implement custom BACK Navigation
        val callBack = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.i(GameplayFragment_TAG, "handleOnBackPressed()")
                // Do nothing
            }
        }
        // Apply the custom BACK Navigation only to this activity ( GameplayFragment )
        requireActivity().onBackPressedDispatcher.addCallback(this, callBack)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(GameplayFragment_TAG, "onCreateView()")

        binding = FragmentPvpGameplayBinding.inflate(inflater, container, false)
        Log.i(GameplayFragment_TAG, "binding = $binding")

        updatePlayersProfile()
        updatePlayersCharImage()

        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(GameplayFragment_TAG, "onCreate()")

        binding!!.col1.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col2.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col3.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col4.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col5.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col6.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col7.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col8.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }
        binding!!.col9.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            onResume()
        }

        binding!!.backToMainMenuButton.setOnClickListener {
            Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

            // Navigate to MainMenuFragment
            findNavController().navigate(R.id.action_gameplayFragment_to_mainMenuFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i(GameplayFragment_TAG, "onResume()")

        // Check whether the game is over
        if (isGameOver()) {
            prompt()
            makeGameplayNotClickable()
            updatePlayersProfile()
            savePlayersProfile() // Save players profile to the files
        }
    }

    private fun fillTheColumn(column: Column) {
        Log.i(GameplayFragment_TAG, "fillTheColumn()")

        // Check who fill the column
        if (onTurn == PLAYER_1) {
            colFilledByP1(column)
            onTurn = PLAYER_2
            Log.i(GameplayFragment_TAG, "onTurn = $onTurn")
        } else {
            colFilledByP2(column)
            onTurn = PLAYER_1
            Log.i(GameplayFragment_TAG, "onTurn = $onTurn")
        }
    }

    private fun colFilledByP1(column: Column) {
        Log.i(GameplayFragment_TAG, "colFilledByP1()")

        column.filledBy = PLAYER_1
        Log.i(GameplayFragment_TAG, "${column.contentDescription} filledBy = ${column.filledBy}")

        if (player1CharGame == CROSS_CHAR) {
            column.setImageResource(R.drawable.silang)
        }
        if (player1CharGame == CIRCLE_CHAR) {
            column.setImageResource(R.drawable.lingkaran)
        }
    }

    private fun colFilledByP2(column: Column) {
        Log.i(GameplayFragment_TAG, "colFilledByP2()")

        column.filledBy = PLAYER_2
        Log.i(GameplayFragment_TAG, "${column.contentDescription} filledBy = ${column.filledBy}")
        if (player2CharGame == CROSS_CHAR) {
            column.setImageResource(R.drawable.silang)
        }
        if (player2CharGame == CIRCLE_CHAR) {
            column.setImageResource(R.drawable.lingkaran)
        }
    }

    private fun isGameOver(): Boolean {
        Log.i(GameplayFragment_TAG, "isGameOver()")

        return if (isThereAWinner()) true
        else if (isDraw()) true
        else false
    }

    private fun prompt() {
        Log.i(GameplayFragment_TAG, "prompt()")

        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_game_over)
            window!!.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
            val gameOverText = findViewById<AppCompatTextView>(R.id.game_over_text)
            if (isThereAWinner()) {
                gameOverText.text = "${whoIsTheWinner()} won!!"
            } else {
                gameOverText.text = "Draw!!"
            }
            findViewById<AppCompatButton>(R.id.main_menu_button).setOnClickListener {
                Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

                findNavController().navigate(R.id.action_gameplayFragment_to_mainMenuFragment)
                dismiss()
            }
            findViewById<AppCompatButton>(R.id.play_again_button).setOnClickListener {
                Log.i(GameplayFragment_TAG, "${it.contentDescription}.setOnClickListener{}")

                findNavController().navigate(R.id.action_gameplayFragment_to_gameSettingFragment)
                dismiss()
            }
            show()
            setCancelable(false)
        }
    }

    private fun makeGameplayNotClickable() {
        Log.i(GameplayFragment_TAG, "makeGameplayNotClickable()")

        binding!!.col1.isClickable = false
        binding!!.col2.isClickable = false
        binding!!.col3.isClickable = false
        binding!!.col4.isClickable = false
        binding!!.col5.isClickable = false
        binding!!.col6.isClickable = false
        binding!!.col7.isClickable = false
        binding!!.col8.isClickable = false
        binding!!.col9.isClickable = false
        binding!!.backToMainMenuButton.isClickable = false
    }

    private fun updatePlayersProfile() {
        Log.i(GameplayFragment_TAG, "updatePlayersProfile()")

        binding!!.player1WinsText.text = "- Wins : $p1NumOfWins"
        binding!!.player1LosesText.text = "- Loses : $p1NumOfLoses"
        binding!!.player2WinsText.text = "- Wins : $p2NumOfWins"
        binding!!.player2LosesText.text = "- Loses : $p2NumOfLoses"
    }

    private fun updatePlayersCharImage() {
        Log.i(GameplayFragment_TAG, "updatePlayersCharImage()")

        if (player1CharGame == CIRCLE_CHAR) {
            binding!!.player1CharImage.setImageResource(R.drawable.lingkaran)
        }
        if (player1CharGame == CROSS_CHAR) {
            binding!!.player1CharImage.setImageResource(R.drawable.silang)
        }

        if (player2CharGame == CIRCLE_CHAR) {
            binding!!.player2CharImage.setImageResource(R.drawable.lingkaran)
        }
        if (player2CharGame == CROSS_CHAR) {
            binding!!.player2CharImage.setImageResource(R.drawable.silang)
        }
    }

    private fun isThereAWinner(): Boolean {
        Log.i(GameplayFragment_TAG, "isThereAWinner()")

        if (binding!!.col1.filledBy == PLAYER_1 && binding!!.col2.filledBy == PLAYER_1 && binding!!.col3.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col4.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col6.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col7.filledBy == PLAYER_1 && binding!!.col8.filledBy == PLAYER_1 && binding!!.col9.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_1 && binding!!.col4.filledBy == PLAYER_1 && binding!!.col7.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col2.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col8.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_1 && binding!!.col6.filledBy == PLAYER_1 && binding!!.col9.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col9.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col7.filledBy == PLAYER_1) {
            theWinner = PLAYER_1
            return true
        }

        /*--------------------------------------------------------------------------------------------------*/

        if (binding!!.col1.filledBy == PLAYER_2 && binding!!.col2.filledBy == PLAYER_2 && binding!!.col3.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col4.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col6.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col7.filledBy == PLAYER_2 && binding!!.col8.filledBy == PLAYER_2 && binding!!.col9.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_2 && binding!!.col4.filledBy == PLAYER_2 && binding!!.col7.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col2.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col8.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_2 && binding!!.col6.filledBy == PLAYER_2 && binding!!.col9.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col9.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col7.filledBy == PLAYER_2) {
            theWinner = PLAYER_2
            return true
        }

        return false
    }

    private fun isDraw(): Boolean {
        Log.i(GameplayFragment_TAG, "isDraw()")

        var count = 0
        if (!binding!!.col1.isEmpty) count++
        if (!binding!!.col2.isEmpty) count++
        if (!binding!!.col3.isEmpty) count++
        if (!binding!!.col4.isEmpty) count++
        if (!binding!!.col5.isEmpty) count++
        if (!binding!!.col6.isEmpty) count++
        if (!binding!!.col7.isEmpty) count++
        if (!binding!!.col8.isEmpty) count++
        if (!binding!!.col9.isEmpty) count++

        return count == 9
    }

    private fun whoIsTheWinner(): String {
        Log.i(GameplayFragment_TAG, "whoIsTheWinner()")

        if (theWinner == PLAYER_1) {
            p1NumOfWins = (p1NumOfWins.toInt() + 1).toString()
            Log.i(GameplayFragment_TAG, "p1NumOfWins = $p1NumOfWins")

            p2NumOfLoses = (p2NumOfLoses.toInt() + 1).toString()
            Log.i(GameplayFragment_TAG, "p2NumOfLoses = $p2NumOfLoses")

            return PLAYER_1
        } else {
            p2NumOfWins = (p2NumOfWins.toInt() + 1).toString()
            Log.i(GameplayFragment_TAG, "p2NumOfWins = $p2NumOfWins")

            p1NumOfLoses = (p1NumOfLoses.toInt() + 1).toString()
            Log.i(GameplayFragment_TAG, "p1NumOfLoses = $p1NumOfLoses")

            return PLAYER_2
        }
    }

    private fun savePlayersProfile() {
        Log.i(GameplayFragment_TAG, "savePlayersProfile()")

        requireContext().openFileOutput(p1WinsFileName, Context.MODE_PRIVATE)
            .write(p1NumOfWins.toByteArray())

        requireContext().openFileOutput(p2LosesFileName, Context.MODE_PRIVATE)
            .write(p2NumOfLoses.toByteArray())

        requireContext().openFileOutput(p2WinsFileName, Context.MODE_PRIVATE)
            .write(p2NumOfWins.toByteArray())

        requireContext().openFileOutput(p1LosesFileName, Context.MODE_PRIVATE)
            .write(p1NumOfLoses.toByteArray())
    }

    private fun readFiles() {
        Log.i(GameplayFragment_TAG, "readFiles()")

        p1NumOfWins = requireContext().openFileInput(p1WinsFileName).reader().readText()
        Log.i(GameplayFragment_TAG, "p1NumOfWins = $p1NumOfWins")

        p1NumOfLoses = requireContext().openFileInput(p1LosesFileName).reader().readText()
        Log.i(GameplayFragment_TAG, "p1NumOfLoses = $p1NumOfLoses")

        p2NumOfWins = requireContext().openFileInput(p2WinsFileName).reader().readText()
        Log.i(GameplayFragment_TAG, "p2NumOfWins = $p2NumOfWins")

        p2NumOfLoses = requireContext().openFileInput(p2LosesFileName).reader().readText()
        Log.i(GameplayFragment_TAG, "p2NumOfLoses = $p2NumOfLoses")
    }

    private fun createFiles() {
        Log.i(GameplayFragment_TAG, "createFiles")

        if (File(requireContext().filesDir, p1WinsFileName).createNewFile()) {
            Log.i(GameplayFragment_TAG, "$p1WinsFileName file created")
            requireContext().openFileOutput(p1WinsFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, p1LosesFileName).createNewFile()) {
            Log.i(GameplayFragment_TAG, "$p1LosesFileName file created")
            requireContext().openFileOutput(p1LosesFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, p2WinsFileName).createNewFile()) {
            Log.i(GameplayFragment_TAG, "$p2WinsFileName file created")
            requireContext().openFileOutput(p2WinsFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, p2LosesFileName).createNewFile()) {
            Log.i(GameplayFragment_TAG, "$p2LosesFileName file created")
            requireContext().openFileOutput(p2LosesFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(GameplayFragment_TAG, "onDestroy()")

        player1CharGame = ""
        Log.i(GameplayFragment_TAG, "player1CharGame = $player1CharGame")

        player2CharGame = ""
        Log.i(GameplayFragment_TAG, "player2CharGame = $player2CharGame")

        firstPlay.value = ""
        Log.i(GameplayFragment_TAG, "firstPlay.value = ${firstPlay.value}")

        binding = null
        Log.i(GameplayFragment_TAG, "binding = $binding")
    }

}