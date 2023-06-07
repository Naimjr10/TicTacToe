package com.nandro.tictactoe

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.nandro.tictactoe.tag.MainActivity_TAG

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(MainActivity_TAG, "onCreate()")

        val image = ImageView(applicationContext)
        image.setImageResource(R.drawable.tic_tac_toe_logo)
        image.scaleType = ImageView.ScaleType.CENTER_INSIDE
        splashScreen(image, 3, R.layout.activity_main)
    }

    private fun splashScreen(imageToShow: ImageView, howLongInSeconds: Long,
                             nextViewToShow: Int) {
        setContentView(imageToShow)
        object : CountDownTimer(howLongInSeconds * 1000, 1000) {
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                setContentView(nextViewToShow)
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainActivity_TAG, "onDestroy()")
    }
}