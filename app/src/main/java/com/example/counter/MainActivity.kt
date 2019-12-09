package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare instance of ViewModel
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("ViewModel", "ViewModel created")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //Add observer
        viewModel.counter.observe(this, Observer<Int>{
            if(viewModel.counter.value == 10) endGame()
            }
        )

        buttonIncrement.setOnClickListener{
            viewModel.increment()
            textViewCounter.text = viewModel.counter.value.toString()
        }

        buttonDecrement.setOnClickListener{
            viewModel.decrement()
            textViewCounter.text = viewModel.counter.value.toString()
        }
    }

    private fun endGame() {
        Toast.makeText(applicationContext, "Counter == 10", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        Log.d("ViewModel", "ViewModel destroyed")
        super.onDestroy()
    }
}
