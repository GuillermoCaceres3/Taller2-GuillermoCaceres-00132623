package com.pmtaller2_00132623_GuillermoCaceres.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmtaller2_00132623_GuillermoCaceres.Models.OrderViewModel

@Composable
fun OrdersScreen(orderViewModel: OrderViewModel = viewModel()) {
    val orders = orderViewModel.orders

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Mis Órdenes", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (orders.isEmpty()) {
            Text("No tienes órdenes en tu carrito.", style = MaterialTheme.typography.bodyMedium)
        } else {
            LazyColumn {
                itemsIndexed(orders) { index, order ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(order.name, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }

        }
    }
}
