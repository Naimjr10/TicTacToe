package com.nandro.tictactoe.PvP

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameSettingViewModel: ViewModel() {
    val playerN = MutableLiveData<String>()
    var count = 0

    override fun onCleared() {
        Log.d("ViewModel", "cleared")
    }
}