package com.codeliner.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var buttonIncrease: Button
    private lateinit var counterTv: TextView
    private lateinit var buttonClear: Button
    private lateinit var buttonDecrease: Button
    private var counterValue = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIncrease = findViewById(R.id.button_increase)
        counterTv = findViewById(R.id.counter)
        buttonClear = findViewById(R.id.button_clear)
        buttonDecrease = findViewById(R.id.button_decrease)

        buttonIncrease.setOnClickListener {
            counterValue++; if (counterValue > 10) counterValue = 10
            counterTv.text = counterValue.toString()
        }
        buttonDecrease.setOnClickListener {
            counterValue--; if (counterValue < 0) counterValue = 0
            counterTv.text = counterValue.toString()
        }
        buttonClear.setOnClickListener {
            counterValue = 0
            counterTv.text = counterValue.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_VALUE_KEY, counterValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counterValue = savedInstanceState.getInt(COUNTER_VALUE_KEY, 0)
        counterTv.text = counterValue.toString()
    }

    private companion object {
        const val COUNTER_VALUE_KEY = "KEY"
    }


}