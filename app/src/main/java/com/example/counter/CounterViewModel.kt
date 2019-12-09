package com.example.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel:ViewModel() {
    private val _counter = MutableLiveData<Int>() //can change and ppl can see

    //live data = it's alive, we can observe the change(if fulfill certain condition then do an action)
    val counter : LiveData<Int> get() = _counter //getter

    init{
        Log.d("ViewModel", "ViewModel Initialised")
        _counter.value = 0
    }

    fun increment(){
        _counter.value = _counter.value?.plus(1)
    }

    fun decrement(){
        _counter.value = _counter.value?.minus(1)
    }

    override fun onCleared() {
        Log.d("ViewModel", "ViewModel cleared")
        super.onCleared()
    }
}