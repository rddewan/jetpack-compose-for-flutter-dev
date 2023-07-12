package com.example.composeforflutterdev.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedProductViewModel: ViewModel() {

    var productId by mutableStateOf("")
        private set

    fun  updateProductId(id: String) {
        productId = id
    }

    override fun onCleared() {
        println("SharedProductViewModel is cleared")
        super.onCleared()
    }
}