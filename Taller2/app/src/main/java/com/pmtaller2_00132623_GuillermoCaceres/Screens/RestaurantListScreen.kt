package com.pmtaller2_00132623_GuillermoCaceres.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pmtaller2_00132623_GuillermoCaceres.Restaurant
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage


@Composable
fun RestaurantListScreen(restaurants: List<Restaurant>, navController: NavController) {
    val categorized = restaurants.groupBy { it.categories.firstOrNull() ?: "Sin Categoria" }

    LazyColumn {
        categorized.forEach { (category, restList) ->
            item {
                Text(text = category, modifier = Modifier.padding(8.dp))
                LazyRow {
                    items(restList) { restaurant ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate("menu/${restaurant.id}")
                                }
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally){
                                AsyncImage(
                                    model = restaurant.imageUrl,
                                    contentDescription = restaurant.name,
                                    modifier = Modifier
                                        .padding(8.dp).height(150.dp)
                                )
                                Text(restaurant.name,modifier = Modifier.padding(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}