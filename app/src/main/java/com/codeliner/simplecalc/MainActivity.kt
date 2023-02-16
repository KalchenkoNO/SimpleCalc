package com.codeliner.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ActivityViewModel
    lateinit var buttonIncrease: Button
    private lateinit var numberTv: TextView
    private lateinit var buttonClear: Button
    private lateinit var buttonDecrease: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        buttonIncrease = findViewById(R.id.button_increase)
        numberTv = findViewById(R.id.counter_tv)
        buttonClear = findViewById(R.id.button_clear)
        buttonDecrease = findViewById(R.id.button_decrease)
        viewModel.getCounterValueLiveData().observe(this, Observer {
            numberTv.text = it.toString()
        })
        buttonIncrease.setOnClickListener {
                viewModel.onButtonClick(R.id.button_increase)
        }
        buttonDecrease.setOnClickListener {
            viewModel.onButtonClick(R.id.button_decrease)
        }
        buttonClear.setOnClickListener {
            viewModel.onButtonClick(R.id.button_clear)
        }
    }
}