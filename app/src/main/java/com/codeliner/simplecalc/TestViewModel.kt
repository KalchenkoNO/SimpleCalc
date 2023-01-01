package com.codeliner.simplecalc

import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    var counterValue = 0

    fun updateCount() {
        counterValue++
        if (counterValue > 10) counterValue = 10
    }

    fun decreaseCount() {
        counterValue--
        if (counterValue < 0) counterValue = 0
    }

}