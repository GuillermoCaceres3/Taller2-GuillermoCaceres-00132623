package com.pmtaller2_00132623_GuillermoCaceres.Models

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.pmtaller2_00132623_GuillermoCaceres.Dish

class OrderViewModel : ViewModel() {
    private val _orders = mutableStateOf<List<Dish>>(emptyList())
    val orders: List<Dish> get() = _orders.value

    fun addToCart(dish: Dish) {
        _orders.value = _orders.value + dish
    }
}
