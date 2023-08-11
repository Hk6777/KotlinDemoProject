package com.example.kotlindemo.JetPackComposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.JetPackComposed.Activity.CityList
import com.example.kotlindemo.JetPackComposed.Activity.ListviewScreen
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme
import com.example.kotlindemo.JetPackComposed.ui.theme.Shapes
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_surfaceTint

class Demo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinDemoTheme {
                // A surface container using the 'background' color from the theme
                YourApp()
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                // Navigate to the second screen when the button is clicked
                navController.navigate("ListviewScreen")
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(md_theme_light_surfaceTint),
            shape = Shapes.extraSmall

        ) {
            Text("Listview & GridView Demo")
        }
        Button(
            onClick = {
                // Navigate to the second screen when the button is clicked
                navController.navigate("citylist")
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(md_theme_light_surfaceTint),
            shape = Shapes.extraSmall

        ) {
            Text("Citylist")
        }
    }
}



@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "firstScreen") {
        composable("firstScreen") { FirstScreen(navController) }
        composable("ListviewScreen") { ListviewScreen() }
        composable("citylist") {
            val cities = listOf(
                "New York",
                "Los Angeles",
                "1",
                "Har",
                "1",
                "Miami",
                "Miami",
                // Add more cities here
            )
            CityList(cities) }
    }
}

@Preview
@Composable
fun YourApp() {
    KotlinDemoTheme {
        App()
    }
}
