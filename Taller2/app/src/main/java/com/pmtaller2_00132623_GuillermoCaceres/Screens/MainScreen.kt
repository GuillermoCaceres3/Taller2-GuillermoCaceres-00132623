package com.pmtaller2_00132623_GuillermoCaceres.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.pmtaller2_00132623_GuillermoCaceres.BottomNavigationBar
import com.pmtaller2_00132623_GuillermoCaceres.Restaurant
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pmtaller2_00132623_GuillermoCaceres.Models.OrderViewModel

@Composable
fun MainScreen(restaurants: List<Restaurant>) {
    val navController = rememberNavController()
    val orderViewModel: OrderViewModel = viewModel()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "restaurants",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("restaurants") {
                RestaurantListScreen(restaurants,navController)
            }
            composable("buscar") {
                SearchScreen(restaurants = restaurants,navController)
            }
            composable("ordenes"){
                OrdersScreen(orderViewModel)
            }
            composable("menu/{restaurantId}") { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getString("restaurantId")?.toInt()
                val restaurant = restaurants.find { it.id == restaurantId }
                restaurant?.let {
                    RestaurantMenuScreen(it,orderViewModel)
                }
            }
        }
    }
}