package com.nandro.tictactoe.customview

import android.animation.Animator
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.nandro.tictactoe.R

class Column(context: Context,
             attrs: AttributeSet?): AppCompatImageView(context, attrs) {
    var isEmpty: Boolean
    var filledBy: String


    init {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.Column)
        isEmpty = typedArray.getBoolean(R.styleable.Column_isEmpty, true)
        filledBy = ""
        typedArray.recycle()
    }

}