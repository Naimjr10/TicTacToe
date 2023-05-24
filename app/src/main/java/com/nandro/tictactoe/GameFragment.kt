package com.nandro.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nandro.tictactoe.ChooseFragment.Companion.isCircleFirst
import com.nandro.tictactoe.ChooseFragment.Companion.isCrossFirst
import com.nandro.tictactoe.databinding.FragmentChooseBinding
import com.nandro.tictactoe.databinding.FragmentGameBinding
import kotlin.properties.Delegates

class GameFragment : Fragment() {
    private var binding: FragmentGameBinding? = null

    private lateinit var isColumnsEmpty: MutableList<Boolean>
    private var colCount: Int = 0
    private lateinit var columnsFilledBy: MutableList<String>

    private var onTurn: String = ""
        set(value) {
            if (isCircleFirst != null || isCrossFirst != null) {
                if (isCircleFirst == true) {
                    field = "circle"
                    isCircleFirst = null
                    isCrossFirst = null
                }
                if (isCrossFirst == true) {
                    field = "cross"
                    isCrossFirst = null
                    isCircleFirst = null
                }
            }
            if (value == "circle") {
                field = value
            }
            if (value == "cross") {
                field = value
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onTurn", onTurn)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        val columns = mutableListOf<AppCompatImageView>()
        for (column in binding!!.frameConstraint) {
            if (column is AppCompatImageView) {
                columns.add(column)
            }
            Log.d("columns", "$column")
        }
        columns.removeAt(0)
        isColumnsEmpty = mutableListOf()
        columnsFilledBy = mutableListOf()
        repeat(columns.size) {
            isColumnsEmpty.add(true)
            columnsFilledBy.add("")
        }
        Log.d("columnsSize", "${columns.size}")
        Log.d("isColumnsEmpty", "$isColumnsEmpty")
        Log.d("columnsFilledBy", "$columnsFilledBy")

        for (column in columns) {
            Log.d("colCount", "$colCount")
            Log.d("column", "$column")
            column.setOnClickListener {
                if (isColumnsEmpty[colCount]) {
                    if (onTurn == "circle") {
                        columnsFilledBy[colCount] = onTurn
                        column.setImageResource(R.drawable.lingkaran)
                        onTurn = "cross"
                    }
                    if (onTurn == "cross") {
                        columnsFilledBy[colCount] = onTurn
                        column.setImageResource(R.drawable.silang)
                        onTurn = "circle"
                    }
                    Log.d("isColumnEmpty", "${isColumnsEmpty.get(colCount)}")
                    isColumnsEmpty[colCount] = false
                    //isFinish()
                }

            }
            if (colCount < 8) {
                colCount++
            }
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    private fun isFinish() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}