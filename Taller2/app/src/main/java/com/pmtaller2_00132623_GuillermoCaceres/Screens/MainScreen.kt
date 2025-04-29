package com.pmtaller2_00132623_GuillermoCaceres.Screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.pmtaller2_00132623_GuillermoCaceres.BottomNavigationBar
import com.pmtaller2_00132623_GuillermoCaceres.Restaurant
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainScreen(restaurants: List<Restaurant>) {
    val navController = rememberNavController()
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

            }


        }
    }
}