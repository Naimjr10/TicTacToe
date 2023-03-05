package com.nandro.tictactoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.ChooseFragment.Companion.circleIsSelectedFirst
import com.nandro.tictactoe.ChooseFragment.Companion.crossIsSelectedFirst
import com.nandro.tictactoe.databinding.FragmentGameBinding
import kotlin.properties.Delegates

class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding

    lateinit var onTurn: String

    var column1IsEmpty = true
    var column2IsEmpty = true
    var column3IsEmpty = true
    var column4IsEmpty = true
    var column5IsEmpty = true
    var column6IsEmpty = true
    var column7IsEmpty = true
    var column8IsEmpty = true
    var column9IsEmpty = true

    var column1isFilledBy = ""
    var column2isFilledBy = ""
    var column3isFilledBy = ""
    var column4isFilledBy = ""
    var column5isFilledBy = ""
    var column6isFilledBy = ""
    var column7isFilledBy = ""
    var column8isFilledBy = ""
    var column9isFilledBy = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.col1.setOnClickListener {

            if (column1IsEmpty) {
                binding.col1.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column1isFilledBy = "Cross"
                } else {
                    column1isFilledBy = "Circle"
                }
                column1IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()

        }

        binding.col2.setOnClickListener {

            if (column2IsEmpty) {
                binding.col2.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column2isFilledBy = "Cross"
                } else {
                    column2isFilledBy = "Circle"
                }
                column2IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col3.setOnClickListener {

            if (column3IsEmpty) {
                binding.col3.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column3isFilledBy = "Cross"
                } else {
                    column3isFilledBy = "Circle"
                }
                column3IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col4.setOnClickListener {

            if (column4IsEmpty) {
                binding.col4.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column4isFilledBy = "Cross"
                } else {
                    column4isFilledBy = "Circle"
                }
                column4IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col5.setOnClickListener {

            if (column5IsEmpty) {
                binding.col5.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column5isFilledBy = "Cross"
                } else {
                    column5isFilledBy = "Circle"
                }
                column5IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col6.setOnClickListener {

            if (column6IsEmpty) {
                binding.col6.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column6isFilledBy = "Cross"
                } else {
                    column6isFilledBy = "Circle"
                }
                column6IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col7.setOnClickListener {

            if (column7IsEmpty) {
                binding.col7.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column7isFilledBy = "Cross"
                } else {
                    column7isFilledBy = "Circle"
                }
                column7IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col8.setOnClickListener {

            if (column8IsEmpty) {
                binding.col8.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column8isFilledBy = "Cross"
                } else {
                    column8isFilledBy = "Circle"
                }
                column8IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }

        binding.col9.setOnClickListener {

            if (column9IsEmpty) {
                binding.col9.setImageResource(generateImage())
                if (onTurn == "Circle") {
                    column9isFilledBy = "Cross"
                } else {
                    column9isFilledBy = "Circle"
                }
                column9IsEmpty = false
            }
            Toast.makeText(activity, "$onTurn", Toast.LENGTH_SHORT).show()
            isFinish()
        }


        binding.newGameButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_chooseFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(activity, "I got destroyed", Toast.LENGTH_SHORT).show()
        circleIsSelectedFirst = false
        crossIsSelectedFirst = false
    }

    fun generateImage(): Int {

        if (ChooseFragment.circleIsSelectedFirst == true) {
            ChooseFragment.circleIsSelectedFirst = false
            onTurn = "Cross"
            return R.drawable.lingkaran
        } else if (ChooseFragment.crossIsSelectedFirst == true) {
            ChooseFragment.crossIsSelectedFirst = false
            onTurn = "Circle"
            return R.drawable.silang
        } else if (onTurn == "Cross") {
            onTurn = "Circle"
            return R.drawable.silang
        } else {
            onTurn = "Cross"
            return R.drawable.lingkaran
        }

    }

    fun isFinish() {
        if (column1isFilledBy == "Circle" && column2isFilledBy == "Circle" && column3isFilledBy == "Circle") {
//            column1IsEmpty = false
//            column2IsEmpty = false
//            column3IsEmpty = false
            column4IsEmpty = false
            column5IsEmpty = false
            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column1isFilledBy $column2isFilledBy $column3isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column4isFilledBy == "Circle" && column5isFilledBy == "Circle" && column6isFilledBy == "Circle") {
            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
//            column4IsEmpty = false
//            column5IsEmpty = false
//            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column4isFilledBy $column5isFilledBy $column6isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column7isFilledBy == "Circle" && column8isFilledBy == "Circle" && column9isFilledBy == "Circle") {
            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
            column4IsEmpty = false
            column5IsEmpty = false
            column6IsEmpty = false
//            column7IsEmpty = false
//            column8IsEmpty = false
//            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column7isFilledBy $column8isFilledBy $column9isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column1isFilledBy == "Circle" && column4isFilledBy == "Circle" && column7isFilledBy == "Circle") {
//            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
//            column4IsEmpty = false
            column5IsEmpty = false
            column6IsEmpty = false
//            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column1isFilledBy $column4isFilledBy $column7isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column2isFilledBy == "Circle" && column5isFilledBy == "Circle" && column8isFilledBy == "Circle") {
            column1IsEmpty = false
//            column2IsEmpty = false
            column3IsEmpty = false
            column4IsEmpty = false
//            column5IsEmpty = false
            column6IsEmpty = false
            column7IsEmpty = false
//            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column2isFilledBy $column5isFilledBy $column8isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column3isFilledBy == "Circle" && column6isFilledBy == "Circle" && column9isFilledBy == "Circle") {
            column1IsEmpty = false
            column2IsEmpty = false
//            column3IsEmpty = false
            column4IsEmpty = false
            column5IsEmpty = false
//            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
//            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column3isFilledBy $column6isFilledBy $column9isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column1isFilledBy == "Circle" && column5isFilledBy == "Circle" && column9isFilledBy == "Circle") {
//            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
            column4IsEmpty = false
//            column5IsEmpty = false
            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
//            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column1isFilledBy $column5isFilledBy $column9isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column3isFilledBy == "Circle" && column5isFilledBy == "Circle" && column7isFilledBy == "Circle") {
            column1IsEmpty = false
            column2IsEmpty = false
//            column3IsEmpty = false
            column4IsEmpty = false
//            column5IsEmpty = false
            column6IsEmpty = false
//            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Circle Won"
            onTurn = ""
            Toast.makeText(activity, "$column3isFilledBy $column5isFilledBy $column7isFilledBy", Toast.LENGTH_SHORT).show()
        }

//------------------------------------------------------------------------------------------------------------//

        if (column1isFilledBy == "Cross" && column2isFilledBy == "Cross" && column3isFilledBy == "Cross") {
//            column1IsEmpty = false
//            column2IsEmpty = false
//            column3IsEmpty = false
            column4IsEmpty = false
            column5IsEmpty = false
            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column1isFilledBy $column2isFilledBy $column3isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column4isFilledBy == "Cross" && column5isFilledBy == "Cross" && column6isFilledBy == "Cross") {
            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
//            column4IsEmpty = false
//            column5IsEmpty = false
//            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column4isFilledBy $column5isFilledBy $column6isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column7isFilledBy == "Cross" && column8isFilledBy == "Cross" && column9isFilledBy == "Cross") {
            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
            column4IsEmpty = false
            column5IsEmpty = false
            column6IsEmpty = false
//            column7IsEmpty = false
//            column8IsEmpty = false
//            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column7isFilledBy $column8isFilledBy $column9isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column1isFilledBy == "Cross" && column4isFilledBy == "Cross" && column7isFilledBy == "Cross") {
//            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
//            column4IsEmpty = false
            column5IsEmpty = false
            column6IsEmpty = false
//            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column1isFilledBy $column4isFilledBy $column7isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column2isFilledBy == "Cross" && column5isFilledBy == "Cross" && column8isFilledBy == "Cross") {
            column1IsEmpty = false
//            column2IsEmpty = false
            column3IsEmpty = false
            column4IsEmpty = false
//            column5IsEmpty = false
            column6IsEmpty = false
            column7IsEmpty = false
//            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column2isFilledBy $column5isFilledBy $column8isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column3isFilledBy == "Cross" && column6isFilledBy == "Cross" && column9isFilledBy == "Cross") {
            column1IsEmpty = false
            column2IsEmpty = false
//            column3IsEmpty = false
            column4IsEmpty = false
            column5IsEmpty = false
//            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
//            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column3isFilledBy $column6isFilledBy $column9isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column1isFilledBy == "Cross" && column5isFilledBy == "Cross" && column9isFilledBy == "Cross") {
//            column1IsEmpty = false
            column2IsEmpty = false
            column3IsEmpty = false
            column4IsEmpty = false
//            column5IsEmpty = false
            column6IsEmpty = false
            column7IsEmpty = false
            column8IsEmpty = false
//            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column1isFilledBy $column5isFilledBy $column9isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column3isFilledBy == "Cross" && column5isFilledBy == "Cross" && column7isFilledBy == "Cross") {
            column1IsEmpty = false
            column2IsEmpty = false
//            column3IsEmpty = false
            column4IsEmpty = false
//            column5IsEmpty = false
            column6IsEmpty = false
//            column7IsEmpty = false
            column8IsEmpty = false
            column9IsEmpty = false

            binding.wonLostMessage.text = "Cross Won"
            onTurn = ""
            Toast.makeText(activity, "$column3isFilledBy $column5isFilledBy $column7isFilledBy", Toast.LENGTH_SHORT).show()
        }

        if (column1IsEmpty == false && column2IsEmpty == false && column3IsEmpty == false &&
            column4IsEmpty == false && column5IsEmpty == false && column6IsEmpty == false &&
            column7IsEmpty == false && column8IsEmpty == false && column9IsEmpty == false && onTurn != "") {

            binding.wonLostMessage.text = "Draw"
        }
    }

}