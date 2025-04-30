package com.pmtaller2_00132623_GuillermoCaceres.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.pmtaller2_00132623_GuillermoCaceres.Restaurant

@Composable
fun SearchScreen(restaurants: List<Restaurant>,navController: NavController) {
    var query by remember { mutableStateOf("") }

    val filteredRestaurants = restaurants.filter {
        it.name.contains(query, ignoreCase = true)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Buscar Restaurantes", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Escribe el nombre del restaurante") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text("Resultados de búsqueda: $query", style = MaterialTheme.typography.bodyMedium)

        LazyColumn {
            items(filteredRestaurants) { restaurant ->
                RestaurantItem(restaurant,navController)
            }
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant,navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { navController.navigate("menu/${restaurant.id}")}
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(restaurant.name, style = MaterialTheme.typography.titleMedium)
            Text(restaurant.description, style = MaterialTheme.typography.bodyMedium)
            AsyncImage(
                model = restaurant.imageUrl,
                contentDescription = restaurant.name,
                modifier = Modifier.height(150.dp)
            )
        }
    }
}


