package com.example.ci_cd_test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _num: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }
    val num: LiveData<Int> = _num

    init {
        _num.value = 0
    }

    fun plusNum() {
        _num.value = (_num.value ?: 0) + 1
    }

    fun resetNum() {
        _num.value = 0
    }
}