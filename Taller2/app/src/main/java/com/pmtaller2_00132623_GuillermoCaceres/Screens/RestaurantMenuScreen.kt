package com.pmtaller2_00132623_GuillermoCaceres.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.pmtaller2_00132623_GuillermoCaceres.Models.OrderViewModel
import com.pmtaller2_00132623_GuillermoCaceres.Restaurant

@Composable
fun RestaurantMenuScreen(restaurant: Restaurant, orderViewModel: OrderViewModel = viewModel()) {
    val context = LocalContext.current
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Text(restaurant.name, style = MaterialTheme.typography.headlineMedium)
            Text(restaurant.description, style = MaterialTheme.typography.bodyLarge)
            AsyncImage(
                model = restaurant.imageUrl,
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 8.dp)
            )
        }

        itemsIndexed(restaurant.dishes) { index, dish ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(dish.name, style = MaterialTheme.typography.titleMedium)
                    Text(dish.description)
                    AsyncImage(
                        model = dish.imageUrl,
                        contentDescription = dish.name,
                        modifier = Modifier.height(150.dp),
                    )
                    Button(onClick = {
                        orderViewModel.addToCart(dish)
                        Toast.makeText(
                            context,
                            "${dish.name} agregado al carrito",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Text("Agregar al carrito")
                    }
                }
            }
        }
    }
}

