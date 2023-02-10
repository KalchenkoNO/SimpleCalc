package com.codeliner.simplecalc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class ActivityViewModel : ViewModel() {
    private var counterValue = 0
    private val counterValueLiveData = liveData<Int> {}

    fun getCounterValueLiveData(): LiveData = counterLiveData

    fun onButtonClick(buttonId: Int) {
        when (buttonId) {
            R.id.button_increase -> updateCount()
            R.id.button_decrease -> decreaseCount()
            R.id.button_clear -> counterValue = 0
        }
    }
    private fun updateCount() {
        counterValue++
        if (counterValue > 10) counterValue = 10
    }
    private fun decreaseCount() {
        counterValue--
        if (counterValue < 0) counterValue = 0
    }
}