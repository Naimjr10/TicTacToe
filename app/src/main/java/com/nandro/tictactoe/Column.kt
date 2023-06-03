package com.nandro.tictactoe

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

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