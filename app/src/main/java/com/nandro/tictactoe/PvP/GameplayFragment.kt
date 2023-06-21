package com.nandro.tictactoe.pvp

import android.app.Dialog
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.customview.Column
import com.nandro.tictactoe.R
import com.nandro.tictactoe.databinding.FragmentPvpGameplayBinding
import com.nandro.tictactoe.pvp.GameSettingFragment.Companion.FIRST_PLAY_KEY
import com.nandro.tictactoe.pvp.GameSettingFragment.Companion.PLAYER1_CHAR_GAME_KEY
import com.nandro.tictactoe.pvp.GameSettingFragment.Companion.PLAYER2_CHAR_GAME_KEY
import com.nandro.tictactoe.tag.GameplayFragment_pvp_TAG
import java.io.File

class GameplayFragment : Fragment() {
    private var binding: FragmentPvpGameplayBinding? = null
    private var onTurn = MutableLiveData("")
    private var theWinner = ""

    private lateinit var p1NumOfWins: String
    private lateinit var p1NumOfLoses: String
    private lateinit var p2NumOfWins: String
    private lateinit var p2NumOfLoses: String

    private var firstPlay: String? = null
    private var player1CharGame: String? = null
    private var player2CharGame: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(GameplayFragment_pvp_TAG, "onCreate()")

        firstPlay= requireArguments().getString(FIRST_PLAY_KEY)
        player1CharGame = requireArguments().getString(PLAYER1_CHAR_GAME_KEY)
        player2CharGame = requireArguments().getString(PLAYER2_CHAR_GAME_KEY)

        if (firstPlay == PLAYER_1) {
            onTurn.value = PLAYER_1
        }
        if (firstPlay == PLAYER_2) {
            onTurn.value = PLAYER_2
        }

        createFiles() // Create files if the files don't exist
        readFiles() // Read the files

        // Implement custom BACK Navigation
        val callBack = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.i(GameplayFragment_pvp_TAG, "handleOnBackPressed()")
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
        Log.i(GameplayFragment_pvp_TAG, "onCreateView()")

        binding = FragmentPvpGameplayBinding.inflate(inflater, container, false)
        Log.i(GameplayFragment_pvp_TAG, "binding = $binding")

        updatePlayersProfile()
        updatePlayersCharImage()

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(GameplayFragment_pvp_TAG, "onCreate()")

        onTurn.observe(viewLifecycleOwner) {
            if (it == PLAYER_1) {
                binding!!.player1CharImage.apply {
                    animation = AlphaAnimation(0.0F, 1.0F)
                    animation.duration = 1000L
                    animation.repeatCount = Animation.INFINITE
                    startAnimation(animation)
                }
                binding!!.player2CharImage.clearAnimation()
            }
            if (it == PLAYER_2) {
                binding!!.player2CharImage.apply {
                    animation = AlphaAnimation(0.0F, 1.0F)
                    animation.duration = 1000L
                    animation.repeatCount = Animation.INFINITE
                    startAnimation(animation)
                }
                binding!!.player1CharImage.clearAnimation()
            }
            if (it == "") {
                binding!!.player1CharImage.clearAnimation()
                binding!!.player2CharImage.clearAnimation()
            }
        }

        binding!!.col1.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col2.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col3.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col4.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col5.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col6.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col7.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col8.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }
        binding!!.col9.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            it as Column
            // Check whether the column is empty
            if (it.isEmpty) {
                fillTheColumn(it)
                MediaPlayer.create(requireContext(), R.raw.mech_keyboard_02_102918).start()
                it.isEmpty = false
            }
            // Check whether the game is over
            if (isGameOver()) {
                onTurn.value = ""
                makeGameplayNotClickable()
                object : CountDownTimer(3000, 1000) {
                    override fun onTick(p0: Long) {
                        MediaPlayer.create(requireContext(), R.raw.interface_124464).start()
                    }
                    override fun onFinish() {
                        prompt()
                        updatePlayersProfile()
                        savePlayersProfile() // Save players profile to the files
                    }
                }.start()
            }
        }

        binding!!.backToMainMenuButton.setOnClickListener {
            Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

            // Navigate to MainMenuFragment
            findNavController().navigate(R.id.action_pvp_gameplayFragment_to_mainMenuFragment)
        }
    }

    private fun fillTheColumn(column: Column) {
        Log.i(GameplayFragment_pvp_TAG, "fillTheColumn()")

        // Check who fill the column
        if (onTurn.value == PLAYER_1) {
            colFilledByP1(column)
            onTurn.value = PLAYER_2
            Log.i(GameplayFragment_pvp_TAG, "onTurn.value = $onTurn.value")
        } else {
            colFilledByP2(column)
            onTurn.value = PLAYER_1
            Log.i(GameplayFragment_pvp_TAG, "onTurn.value = $onTurn.value")
        }
    }

    private fun colFilledByP1(column: Column) {
        Log.i(GameplayFragment_pvp_TAG, "colFilledByP1()")

        column.filledBy = PLAYER_1
        Log.i(GameplayFragment_pvp_TAG, "${column.contentDescription} filledBy = ${column.filledBy}")

        if (player1CharGame == CROSS_CHAR) {
            column.setImageResource(R.drawable.silang)
        }
        if (player1CharGame == CIRCLE_CHAR) {
            column.setImageResource(R.drawable.lingkaran)
        }
    }

    private fun colFilledByP2(column: Column) {
        Log.i(GameplayFragment_pvp_TAG, "colFilledByP2()")

        column.filledBy = PLAYER_2
        Log.i(GameplayFragment_pvp_TAG, "${column.contentDescription} filledBy = ${column.filledBy}")
        if (player2CharGame == CROSS_CHAR) {
            column.setImageResource(R.drawable.silang)
        }
        if (player2CharGame == CIRCLE_CHAR) {
            column.setImageResource(R.drawable.lingkaran)
        }
    }

    private fun isGameOver(): Boolean {
        Log.i(GameplayFragment_pvp_TAG, "isGameOver()")

        return if (isThereAWinner()) true
        else if (isDraw()) true
        else false
    }

    private fun prompt() {
        Log.i(GameplayFragment_pvp_TAG, "prompt()")

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
                Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

                findNavController().navigate(R.id.action_pvp_gameplayFragment_to_mainMenuFragment)
                dismiss()
            }
            findViewById<AppCompatButton>(R.id.play_again_button).setOnClickListener {
                Log.i(GameplayFragment_pvp_TAG, "${it.contentDescription}.setOnClickListener{}")

                findNavController().navigate(R.id.action_pvp_gameplayFragment_to_pvp_gameSettingFragment)
                dismiss()
            }
            show()
            setCancelable(false)
        }
    }

    private fun makeGameplayNotClickable() {
        Log.i(GameplayFragment_pvp_TAG, "makeGameplayNotClickable()")

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
        Log.i(GameplayFragment_pvp_TAG, "updatePlayersProfile()")

        binding!!.player1WinsText.text = "- Wins : $p1NumOfWins"
        binding!!.player1LosesText.text = "- Loses : $p1NumOfLoses"
        binding!!.player2WinsText.text = "- Wins : $p2NumOfWins"
        binding!!.player2LosesText.text = "- Loses : $p2NumOfLoses"
    }

    private fun updatePlayersCharImage() {
        Log.i(GameplayFragment_pvp_TAG, "updatePlayersCharImage()")

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
        Log.i(GameplayFragment_pvp_TAG, "isThereAWinner()")

        if (binding!!.col1.filledBy == PLAYER_1 && binding!!.col2.filledBy == PLAYER_1 && binding!!.col3.filledBy == PLAYER_1) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col2)
            playAnimation(binding!!.col3)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col4.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col6.filledBy == PLAYER_1) {
            playAnimation(binding!!.col4)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col6)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col7.filledBy == PLAYER_1 && binding!!.col8.filledBy == PLAYER_1 && binding!!.col9.filledBy == PLAYER_1) {
            playAnimation(binding!!.col7)
            playAnimation(binding!!.col8)
            playAnimation(binding!!.col9)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_1 && binding!!.col4.filledBy == PLAYER_1 && binding!!.col7.filledBy == PLAYER_1) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col4)
            playAnimation(binding!!.col7)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col2.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col8.filledBy == PLAYER_1) {
            playAnimation(binding!!.col2)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col8)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_1 && binding!!.col6.filledBy == PLAYER_1 && binding!!.col9.filledBy == PLAYER_1) {
            playAnimation(binding!!.col3)
            playAnimation(binding!!.col6)
            playAnimation(binding!!.col9)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col9.filledBy == PLAYER_1) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col9)

            theWinner = PLAYER_1
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_1 && binding!!.col5.filledBy == PLAYER_1 && binding!!.col7.filledBy == PLAYER_1) {
            playAnimation(binding!!.col3)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col7)

            theWinner = PLAYER_1
            return true
        }

        /*--------------------------------------------------------------------------------------------------*/

        if (binding!!.col1.filledBy == PLAYER_2 && binding!!.col2.filledBy == PLAYER_2 && binding!!.col3.filledBy == PLAYER_2) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col2)
            playAnimation(binding!!.col3)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col4.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col6.filledBy == PLAYER_2) {
            playAnimation(binding!!.col4)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col6)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col7.filledBy == PLAYER_2 && binding!!.col8.filledBy == PLAYER_2 && binding!!.col9.filledBy == PLAYER_2) {
            playAnimation(binding!!.col7)
            playAnimation(binding!!.col8)
            playAnimation(binding!!.col9)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_2 && binding!!.col4.filledBy == PLAYER_2 && binding!!.col7.filledBy == PLAYER_2) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col4)
            playAnimation(binding!!.col7)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col2.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col8.filledBy == PLAYER_2) {
            playAnimation(binding!!.col2)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col8)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_2 && binding!!.col6.filledBy == PLAYER_2 && binding!!.col9.filledBy == PLAYER_2) {
            playAnimation(binding!!.col3)
            playAnimation(binding!!.col6)
            playAnimation(binding!!.col9)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col1.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col9.filledBy == PLAYER_2) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col9)

            theWinner = PLAYER_2
            return true
        }
        if (binding!!.col3.filledBy == PLAYER_2 && binding!!.col5.filledBy == PLAYER_2 && binding!!.col7.filledBy == PLAYER_2) {
            playAnimation(binding!!.col3)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col7)

            theWinner = PLAYER_2
            return true
        }

        return false
    }

    private fun isDraw(): Boolean {
        Log.i(GameplayFragment_pvp_TAG, "isDraw()")

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

        if (count == 9) {
            playAnimation(binding!!.col1)
            playAnimation(binding!!.col2)
            playAnimation(binding!!.col3)
            playAnimation(binding!!.col4)
            playAnimation(binding!!.col5)
            playAnimation(binding!!.col6)
            playAnimation(binding!!.col7)
            playAnimation(binding!!.col8)
            playAnimation(binding!!.col9)
        }

        return count == 9
    }

    private fun whoIsTheWinner(): String {
        Log.i(GameplayFragment_pvp_TAG, "whoIsTheWinner()")

        if (theWinner == PLAYER_1) {
            p1NumOfWins = (p1NumOfWins.toInt() + 1).toString()
            Log.i(GameplayFragment_pvp_TAG, "p1NumOfWins = $p1NumOfWins")

            p2NumOfLoses = (p2NumOfLoses.toInt() + 1).toString()
            Log.i(GameplayFragment_pvp_TAG, "p2NumOfLoses = $p2NumOfLoses")

            return PLAYER_1
        } else {
            p2NumOfWins = (p2NumOfWins.toInt() + 1).toString()
            Log.i(GameplayFragment_pvp_TAG, "p2NumOfWins = $p2NumOfWins")

            p1NumOfLoses = (p1NumOfLoses.toInt() + 1).toString()
            Log.i(GameplayFragment_pvp_TAG, "p1NumOfLoses = $p1NumOfLoses")

            return PLAYER_2
        }
    }

    private fun savePlayersProfile() {
        Log.i(GameplayFragment_pvp_TAG, "savePlayersProfile()")

        requireContext().openFileOutput(P1_WINS_FILE_NAME, Context.MODE_PRIVATE)
            .write(p1NumOfWins.toByteArray())

        requireContext().openFileOutput(P2_LOSES_FILE_NAME, Context.MODE_PRIVATE)
            .write(p2NumOfLoses.toByteArray())

        requireContext().openFileOutput(P2_WINS_FILE_NAME, Context.MODE_PRIVATE)
            .write(p2NumOfWins.toByteArray())

        requireContext().openFileOutput(P1_LOSES_FILE_NAME, Context.MODE_PRIVATE)
            .write(p1NumOfLoses.toByteArray())
    }

    private fun readFiles() {
        Log.i(GameplayFragment_pvp_TAG, "readFiles()")

        p1NumOfWins = requireContext().openFileInput(P1_WINS_FILE_NAME).reader().readText()
        Log.i(GameplayFragment_pvp_TAG, "p1NumOfWins = $p1NumOfWins")

        p1NumOfLoses = requireContext().openFileInput(P1_LOSES_FILE_NAME).reader().readText()
        Log.i(GameplayFragment_pvp_TAG, "p1NumOfLoses = $p1NumOfLoses")

        p2NumOfWins = requireContext().openFileInput(P2_WINS_FILE_NAME).reader().readText()
        Log.i(GameplayFragment_pvp_TAG, "p2NumOfWins = $p2NumOfWins")

        p2NumOfLoses = requireContext().openFileInput(P2_LOSES_FILE_NAME).reader().readText()
        Log.i(GameplayFragment_pvp_TAG, "p2NumOfLoses = $p2NumOfLoses")
    }

    private fun createFiles() {
        Log.i(GameplayFragment_pvp_TAG, "createFiles")

        if (File(requireContext().filesDir, P1_WINS_FILE_NAME).createNewFile()) {
            Log.i(GameplayFragment_pvp_TAG, "$P1_WINS_FILE_NAME file created")
            requireContext().openFileOutput(P1_WINS_FILE_NAME, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, P1_LOSES_FILE_NAME).createNewFile()) {
            Log.i(GameplayFragment_pvp_TAG, "$P1_LOSES_FILE_NAME file created")
            requireContext().openFileOutput(P1_LOSES_FILE_NAME, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, P2_WINS_FILE_NAME).createNewFile()) {
            Log.i(GameplayFragment_pvp_TAG, "$P2_WINS_FILE_NAME file created")
            requireContext().openFileOutput(P2_WINS_FILE_NAME, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
        if (File(requireContext().filesDir, P2_LOSES_FILE_NAME).createNewFile()) {
            Log.i(GameplayFragment_pvp_TAG, "$P2_LOSES_FILE_NAME file created")
            requireContext().openFileOutput(P2_LOSES_FILE_NAME, Context.MODE_PRIVATE)
                .write("0".toByteArray())
        }
    }

    private fun playAnimation(col: Column) {
        col.apply {
            animation = AlphaAnimation(0.0F, 1.0F)
            animation.duration = 1000L
            animation.repeatCount = 2
            startAnimation(animation)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(GameplayFragment_pvp_TAG, "onDestroy()")

        binding = null
        Log.i(GameplayFragment_pvp_TAG, "binding = null")
    }

}