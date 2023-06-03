package com.nandro.tictactoe.PvP

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.Column
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameplayBinding
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.PLAYER_2
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.PLAYER_1
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.player1CharGame
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.player2CharGame
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.CIRCLE_CHAR
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.CROSS_CHAR
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting.firstPlay
import java.io.File

class GameplayFragment : Fragment() {
    private var binding: FragmentPvpGameplayBinding? = null
    private var onTurn = ""
    private var theWinner = ""

    private val p1WinsFileName = "P1_num_of_wins"
    private val p1LosesFileName = "P1_num_of_loses"
    private val p2WinsFileName = "P2_num_of_wins"
    private val p2LosesFileName = "P2_num_of_loses"

    private lateinit var p1NumOfWins: String
    private lateinit var p1NumOfLoses: String
    private lateinit var p2NumOfWins: String
    private lateinit var p2NumOfLoses: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("GameplayFragment", "created")

        // Create files if the files don't exist
        createFiles()
        initState()

        Log.i("lifecycle", "${lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPvpGameplayBinding.inflate(inflater, container, false)
        updatePlayersProfile()
        updatePlayersCharImage()

        Log.i("lifecycle", "${viewLifecycleOwner.lifecycle.currentState}")
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.col1.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }
            Log.i("lifecycle", "${lifecycle.currentState}")
            Log.i("lifecycle", "${viewLifecycleOwner.lifecycle.currentState}")
        }

        binding!!.col2.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }
            Log.i("lifecycle", "${lifecycle.currentState}")
        }

        binding!!.col3.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }

        }
        binding!!.col4.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }
        }
        binding!!.col5.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }

        }
        binding!!.col6.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }

        }
        binding!!.col7.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }

        }
        binding!!.col8.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }

        }
        binding!!.col9.setOnClickListener {
            it as Column
            if (it.isEmpty) {
                fillTheColumn(it)
                it.isEmpty = false
            }
            if (isGameOver()) {
                Log.d("isGameOver", "${isGameOver()}")
                makeGameplayNotClickable()
                saveState()
                updatePlayersProfile()
                prompt()
            }

        }

        binding!!.newGameButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameplayFragment_to_gameSettingFragment)
        }
    }

    private fun fillTheColumn(column: Column) {
        if (whoFillTheColumn() == PLAYER_1) {
            colFilledByP1(column)
            onTurn = PLAYER_2
        } else {
            colFilledByP2(column)
            onTurn = PLAYER_1
        }
    }

    private fun whoFillTheColumn(): String {
        return if (onTurn == PLAYER_1) PLAYER_1
        else PLAYER_2
    }

    private fun colFilledByP1(column: Column) {
        column.filledBy = PLAYER_1
        if (player1CharGame == CROSS_CHAR) {
            column.setImageResource(R.drawable.silang)
        }
        if (player1CharGame == CIRCLE_CHAR) {
            column.setImageResource(R.drawable.lingkaran)
        }
    }

    private fun colFilledByP2(column: Column) {
        column.filledBy = PLAYER_2
        if (player2CharGame == CROSS_CHAR) {
            column.setImageResource(R.drawable.silang)
        }
        if (player2CharGame == CIRCLE_CHAR) {
            column.setImageResource(R.drawable.lingkaran)
        }
    }

    private fun isGameOver(): Boolean {
        return if (isThereAWinner()) true
        else if (isDraw()) true
        else false
    }

    private fun prompt() {
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_game_over)
            window!!.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
            val gameOverText = findViewById<AppCompatTextView>(R.id.game_over_text)
            if (theWinner != "") {
                gameOverText.text = "${whoIsTheWinner()} win!!"
            } else {
                gameOverText.text = "Draw!!"
            }
            findViewById<AppCompatButton>(R.id.main_menu_button).setOnClickListener {
                findNavController().navigate(R.id.action_gameplayFragment_to_mainMenuFragment)
                dismiss()
            }
            findViewById<AppCompatButton>(R.id.new_game_button).setOnClickListener {
                findNavController().navigate(R.id.action_gameplayFragment_to_gameSettingFragment)
                dismiss()
            }
            show()
            findNavController().enableOnBackPressed(false)
        }
    }

    private fun makeGameplayNotClickable() {
        binding!!.col1.isClickable = false
        binding!!.col2.isClickable = false
        binding!!.col3.isClickable = false
        binding!!.col4.isClickable = false
        binding!!.col5.isClickable = false
        binding!!.col6.isClickable = false
        binding!!.col7.isClickable = false
        binding!!.col8.isClickable = false
        binding!!.col9.isClickable = false
        binding!!.newGameButton.isClickable = false
    }

    private fun updatePlayersProfile() {
        binding!!.player1WinsText.text = "- Wins : $p1NumOfWins"
        binding!!.player1LosesText.text = "- Loses : $p1NumOfLoses"
        binding!!.player2WinsText.text = "- Wins : $p2NumOfWins"
        binding!!.player2LosesText.text = "- Loses : $p2NumOfLoses"
    }

    private fun updatePlayersCharImage() {

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
        return if (theWinner == PLAYER_1)
            PLAYER_1 else PLAYER_2
    }

    private fun saveState() {
        if (theWinner == PLAYER_1) {
            p1NumOfWins = (p1NumOfWins.toInt() + 1).toString()
            requireContext().openFileOutput(p1WinsFileName, Context.MODE_PRIVATE)
                .write(p1NumOfWins.toByteArray())

            p2NumOfLoses = (p2NumOfLoses.toInt() + 1).toString()
            requireContext().openFileOutput(p2LosesFileName, Context.MODE_PRIVATE)
                .write(p2NumOfLoses.toByteArray())
        }

        if (theWinner == PLAYER_2) {
            p2NumOfWins = (p2NumOfWins.toInt() + 1).toString()
            requireContext().openFileOutput(p2WinsFileName, Context.MODE_PRIVATE)
                .write(p2NumOfWins.toByteArray())

            p1NumOfLoses = (p1NumOfLoses.toInt() + 1).toString()
            requireContext().openFileOutput(p1LosesFileName, Context.MODE_PRIVATE)
                .write(p1NumOfLoses.toByteArray())
        }
    }

    private fun initState() {
        p1NumOfWins = requireContext().openFileInput(p1WinsFileName).reader().readText()
        p1NumOfLoses = requireContext().openFileInput(p1LosesFileName).reader().readText()
        p2NumOfWins = requireContext().openFileInput(p2WinsFileName).reader().readText()
        p2NumOfLoses = requireContext().openFileInput(p2LosesFileName).reader().readText()


        if (firstPlay.value == PLAYER_1) {
            onTurn = PLAYER_1
        }
        if (firstPlay.value == PLAYER_2) {
            onTurn = PLAYER_2
        }
    }

    private fun createFiles() {
        if (File(requireContext().filesDir, p1WinsFileName).createNewFile()) {
            requireContext().openFileOutput(p1WinsFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, p1LosesFileName).createNewFile()) {
            requireContext().openFileOutput(p1LosesFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, p2WinsFileName).createNewFile()) {
            requireContext().openFileOutput(p2WinsFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, p2LosesFileName).createNewFile()) {
            requireContext().openFileOutput(p2LosesFileName, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GameplayFragment", "destroyed")
        player1CharGame = ""
        player2CharGame = ""
        firstPlay.value = ""
    }

}