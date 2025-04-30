package com.pmtaller2_00132623_GuillermoCaceres

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pmtaller2_00132623_GuillermoCaceres.Screens.MainScreen
import com.pmtaller2_00132623_GuillermoCaceres.ui.theme.FoodSpotByGCaceresTheme

data class Dish(
    val id: Int,
    val name : String,
    val description: String,
    val imageUrl: String
)

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,
    val dishes: List<Dish>
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByGCaceresTheme {
                val restaurants = getRestaurants()
                MainScreen(restaurants = restaurants)
                }

            }
        }
    }

private fun getRestaurants(): List<Restaurant> {
    return listOf(
       Restaurant(1, "Mcdonalds", "Restaurante de hamburguesas", "https://1000marcas.net/wp-content/uploads/2019/11/McDonalds-logo-tumb-150x150.jpg",
            listOf("Fast food"), listOf(
            Dish(1, "Big mac", "Doble carne", "https://thelogic.co/wp-content/uploads/2025/02/BigMac_red-TheLogic_Illustration-P_Handout-1920x1280-1.jpg"),
            Dish(2, "Cuarto de libra", "Jugosa", "https://imagenes.eltiempo.com/files/image_600_455/files/fp/uploads/2024/10/23/6718f7224a985.r_d.971-1065.png")
        )),
        Restaurant(2, "Burger King", "Restaurante de burgers", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Burger_King_2020.svg/1200px-Burger_King_2020.svg.png", listOf("Fast food"), listOf(
            Dish(3, "Whopper", "La mejor burger", "https://static.wikia.nocookie.net/burgerking/images/a/ae/Whopper_Sandwich.png/revision/latest?cb=20190619155131"),
            Dish(4, "Big king", "Sanwich de pollo", "https://bk-latam-prod.s3.amazonaws.com/sites/burgerking.latam/files/BK_Web_Big-King_500X540px.png")
        )),
        Restaurant(3, "Tacos hermanos", "Los mejores tacos", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI6KhSWtBzu5vvvkZwYtYF6pA9ioLE0rrnM41asvnIw-IRHt3efL7DJPXeldCIGtSJqgE&usqp=CAU", listOf("Mexicana"), listOf(
            Dish(5, "Tacos tradicionales", "4 tacos a eleccion", "https://comelongo.com/wp-content/uploads/2022/05/260409637_229207146009294_7822634584804299539_n-580x408.jpg"),
            Dish(6, "Sopa de tortilla", "Gran sopa de tortilla", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtkFbTftQEinEVvohyt2owRGgQS13mPUXqoQ&s")
        ))

    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotByGCaceresTheme {
        Greeting("Android")
    }
}