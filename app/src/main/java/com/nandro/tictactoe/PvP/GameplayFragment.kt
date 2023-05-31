package com.nandro.tictactoe.PvP

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameplayBinding
import com.nandro.tictactoe.PvP.GameSettingFragment.GameSetting

class GameplayFragment : Fragment() {
    var binding: FragmentPvpGameplayBinding? = null
    var onTurn = ""
    val isColumnsEmpty = mutableListOf<Boolean>()
    val columnsFilledBy = mutableListOf<String>()
    var theWinner = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("GameplayFragment", "created")

        repeat(9) {
            isColumnsEmpty.add(true)
            columnsFilledBy.add("")
        }
        if (GameSetting.firstPlay.value == GameSetting.PLAYER_1) {
            onTurn = GameSetting.PLAYER_1
        }
        if (GameSetting.firstPlay.value == GameSetting.PLAYER_2) {
            onTurn = GameSetting.PLAYER_2
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPvpGameplayBinding.inflate(inflater, container, false)
        updatePlayersProfile()

        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding!!.col1.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn1Empty", "${isColumnsEmpty[0]}")
            it as AppCompatImageView
            if (isColumnsEmpty[0]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[0] = GameSetting.PLAYER_1
                    Log.d("column1FilledBy", columnsFilledBy[0])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[0] = GameSetting.PLAYER_2
                    Log.d("column1FilledBy", columnsFilledBy[0])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", "onTurn = $onTurn")
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[0] = false
                Log.d("isColumn1Empty", "${isColumnsEmpty[0]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }

            }
        }
        binding!!.col2.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn2Empty", "${isColumnsEmpty[1]}")
            it as AppCompatImageView
            if (isColumnsEmpty[1]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[1] = GameSetting.PLAYER_1
                    Log.d("column2FilledBy", columnsFilledBy[1])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[1] = GameSetting.PLAYER_2
                    Log.d("column2FilledBy", columnsFilledBy[1])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[1] = false
                Log.d("isColumn2Empty", "${isColumnsEmpty[1]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col3.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn3Empty", "${isColumnsEmpty[2]}")
            it as AppCompatImageView
            if (isColumnsEmpty[2]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[2] = GameSetting.PLAYER_1
                    Log.d("column3FilledBy", columnsFilledBy[2])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[2] = GameSetting.PLAYER_2
                    Log.d("column3FilledBy", columnsFilledBy[2])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[2] = false
                Log.d("isColumn3Empty", "${isColumnsEmpty[2]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col4.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn4Empty", "${isColumnsEmpty[3]}")
            it as AppCompatImageView
            if (isColumnsEmpty[3]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[3] = GameSetting.PLAYER_1
                    Log.d("column4FilledBy", columnsFilledBy[3])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[3] = GameSetting.PLAYER_2
                    Log.d("column4FilledBy", columnsFilledBy[3])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[3] = false
                Log.d("isColumn4Empty", "${isColumnsEmpty[3]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col5.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn5Empty", "${isColumnsEmpty[4]}")
            it as AppCompatImageView
            if (isColumnsEmpty[4]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[4] = GameSetting.PLAYER_1
                    Log.d("column5FilledBy", columnsFilledBy[4])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[4] = GameSetting.PLAYER_2
                    Log.d("column5FilledBy", columnsFilledBy[4])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[4] = false
                Log.d("isColumn5Empty", "${isColumnsEmpty[4]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col6.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn6Empty", "${isColumnsEmpty[5]}")
            it as AppCompatImageView
            if (isColumnsEmpty[5]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[5] = GameSetting.PLAYER_1
                    Log.d("column6FilledBy", columnsFilledBy[5])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }

                } else {
                    columnsFilledBy[5] = GameSetting.PLAYER_2
                    Log.d("column6FilledBy", columnsFilledBy[5])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[5] = false
                Log.d("isColumn6Empty", "${isColumnsEmpty[5]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col7.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn7Empty", "${isColumnsEmpty[6]}")
            it as AppCompatImageView
            if (isColumnsEmpty[6]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[6] = GameSetting.PLAYER_1
                    Log.d("column7FilledBy", columnsFilledBy[6])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[6] = GameSetting.PLAYER_2
                    Log.d("column7FilledBy", columnsFilledBy[6])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[6] = false
                Log.d("isColumn7Empty", "${isColumnsEmpty[6]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col8.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn8Empty", "${isColumnsEmpty[7]}")
            it as AppCompatImageView
            if (isColumnsEmpty[7]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[7] = GameSetting.PLAYER_1
                    Log.d("column8FilledBy", columnsFilledBy[7])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[7] = GameSetting.PLAYER_2
                    Log.d("column8FilledBy", columnsFilledBy[7])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[7] = false
                Log.d("isColumn8Empty", "${isColumnsEmpty[7]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }
            }
        }
        binding!!.col9.setOnClickListener {
            Log.d("onTurn", onTurn)
            Log.d("isColumn9Empty", "${isColumnsEmpty[8]}")
            it as AppCompatImageView
            if (isColumnsEmpty[8]) {
                if (onTurn == GameSetting.PLAYER_1) {
                    columnsFilledBy[8] = GameSetting.PLAYER_1
                    Log.d("column9FilledBy", columnsFilledBy[8])
                    onTurn = GameSetting.PLAYER_2
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                } else {
                    columnsFilledBy[8] = GameSetting.PLAYER_2
                    Log.d("column9FilledBy", columnsFilledBy[8])
                    onTurn = GameSetting.PLAYER_1
                    Log.d("onTurn", onTurn)
                    if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
                        it.setImageResource(R.drawable.lingkaran)
                    }
                    if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
                        it.setImageResource(R.drawable.silang)
                    }
                }
                isColumnsEmpty[8] = false
                Log.d("isColumn9Empty", "${isColumnsEmpty[8]}")
                if (isGameOver()) {
                    Log.d("isGameOver", "${isGameOver()}")
                    makeGameplayNotClickable()
                    prompt()
                }            }
        }

        binding!!.newGameButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameplayFragment_to_gameSettingFragment)
        }
    }

    private fun isGameOver(): Boolean {
        if (columnsFilledBy[0] == GameSetting.PLAYER_1 && columnsFilledBy[1] == GameSetting.PLAYER_1 && columnsFilledBy[2] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }
        if (columnsFilledBy[3] == GameSetting.PLAYER_1 && columnsFilledBy[4] == GameSetting.PLAYER_1 && columnsFilledBy[5] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }
        if (columnsFilledBy[6] == GameSetting.PLAYER_1 && columnsFilledBy[7] == GameSetting.PLAYER_1 && columnsFilledBy[8] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }

        if (columnsFilledBy[0] == GameSetting.PLAYER_1 && columnsFilledBy[3] == GameSetting.PLAYER_1 && columnsFilledBy[6] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }
        if (columnsFilledBy[1] == GameSetting.PLAYER_1 && columnsFilledBy[4] == GameSetting.PLAYER_1 && columnsFilledBy[7] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }
        if (columnsFilledBy[2] == GameSetting.PLAYER_1 && columnsFilledBy[5] == GameSetting.PLAYER_1 && columnsFilledBy[8] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }

        if (columnsFilledBy[0] == GameSetting.PLAYER_1 && columnsFilledBy[4] == GameSetting.PLAYER_1 && columnsFilledBy[8] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }
        if (columnsFilledBy[2] == GameSetting.PLAYER_1 && columnsFilledBy[4] == GameSetting.PLAYER_1 && columnsFilledBy[6] == GameSetting.PLAYER_1 ) {
            theWinner = GameSetting.PLAYER_1
            return true
        }
        /*--------------------------------------------------------------------------------------------------------------------------------*/

        if (columnsFilledBy[0] == GameSetting.PLAYER_2 && columnsFilledBy[1] == GameSetting.PLAYER_2 && columnsFilledBy[2] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }
        if (columnsFilledBy[3] == GameSetting.PLAYER_2 && columnsFilledBy[4] == GameSetting.PLAYER_2 && columnsFilledBy[5] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }
        if (columnsFilledBy[6] == GameSetting.PLAYER_2 && columnsFilledBy[7] == GameSetting.PLAYER_2 && columnsFilledBy[8] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }

        if (columnsFilledBy[0] == GameSetting.PLAYER_2 && columnsFilledBy[3] == GameSetting.PLAYER_2 && columnsFilledBy[6] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }
        if (columnsFilledBy[1] == GameSetting.PLAYER_2 && columnsFilledBy[4] == GameSetting.PLAYER_2 && columnsFilledBy[7] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }
        if (columnsFilledBy[2] == GameSetting.PLAYER_2 && columnsFilledBy[5] == GameSetting.PLAYER_2 && columnsFilledBy[8] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }

        if (columnsFilledBy[0] == GameSetting.PLAYER_2 && columnsFilledBy[4] == GameSetting.PLAYER_2 && columnsFilledBy[8] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }
        if (columnsFilledBy[2] == GameSetting.PLAYER_2 && columnsFilledBy[4] == GameSetting.PLAYER_2 && columnsFilledBy[6] == GameSetting.PLAYER_2 ) {
            theWinner = GameSetting.PLAYER_2
            return true
        }
        /*--------------------------------------------------------------------------------------------------------------------------------*/

        return isColumnsEmpty.all { it == false }
    }

    private fun prompt() {
        val dialog = Dialog(requireContext())
        dialog.apply {
            setContentView(R.layout.dialog_game_over)
            window!!.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
            val gameOverText = findViewById<AppCompatTextView>(R.id.game_over_text)
            if (theWinner != "") {
                if (theWinner == GameSetting.PLAYER_1) {
                    gameOverText.text = "Player 1 win!!"
                }
                if (theWinner == GameSetting.PLAYER_2) {
                    gameOverText.text = "Player 2 win!!"
                }
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
        if (GameSetting.player1CharGame == GameSetting.CIRCLE_CHAR) {
            binding!!.player1CharImage.setImageResource(R.drawable.lingkaran)
        }
        if (GameSetting.player1CharGame == GameSetting.CROSS_CHAR) {
            binding!!.player1CharImage.setImageResource(R.drawable.silang)
        }

        if (GameSetting.player2CharGame == GameSetting.CIRCLE_CHAR) {
            binding!!.player2CharImage.setImageResource(R.drawable.lingkaran)
        }
        if (GameSetting.player2CharGame == GameSetting.CROSS_CHAR) {
            binding!!.player2CharImage.setImageResource(R.drawable.silang)
        }
    }

    private fun isThereAWinner(): Boolean {
        return theWinner != ""
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("GameplayFragment", "destroyed")
        GameSetting.player1CharGame = ""
        GameSetting.player2CharGame = ""
        GameSetting.firstPlay.value = ""
    }

}