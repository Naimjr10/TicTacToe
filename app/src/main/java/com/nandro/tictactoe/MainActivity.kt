package com.nandro.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nandro.tictactoe.tag.MainActivity_TAG

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(MainActivity_TAG, "onCreate()")

        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainActivity_TAG, "onDestroy()")
    }
}