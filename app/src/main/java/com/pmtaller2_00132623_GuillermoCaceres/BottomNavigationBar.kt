package com.pmtaller2_00132623_GuillermoCaceres

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pmtaller2_00132623_GuillermoCaceres.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Restaurantes", "restaurants", Icons.Default.Home),
        BottomNavItem("Buscar","buscar", Icons.Default.Search),
        BottomNavItem("Ordenes","ordenes,", Icons.Default.ShoppingCart,)
    )

    NavigationBar {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(text = item.label) },
                selected = currentDestination == item.route,
                onClick = { navController.navigate(item.route) }
            )
        }
    }
}

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector
)



