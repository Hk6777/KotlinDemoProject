package com.example.kotlindemo.JetPackComposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.JetPackComposed.Activity.CityList
import com.example.kotlindemo.JetPackComposed.Activity.FullScreenImageGallery
import com.example.kotlindemo.JetPackComposed.Activity.GalleryActivity
import com.example.kotlindemo.JetPackComposed.Activity.ListviewScreen
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_errorContainer

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
fun FirstScreen(navController: NavController, exapleList: List<String>) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
//        Button(
//            onClick = {
//                // Navigate to the second screen when the button is clicked
//                navController.navigate("ListviewScreen")
//            },
//            modifier = Modifier
//                .padding(8.dp)
//                .fillMaxWidth(),
//            colors = ButtonDefaults.buttonColors(md_theme_light_surfaceTint),
//            shape = Shapes.extraSmall
//
//        ) {
//            Text("Listview & GridView Demo")
//        }
//        Button(
//            onClick = {
//                // Navigate to the second screen when the button is clicked
//                navController.navigate("citylist")
//            },
//            modifier = Modifier
//                .padding(8.dp)
//                .fillMaxWidth(),
//            colors = ButtonDefaults.buttonColors(md_theme_light_surfaceTint),
//            shape = Shapes.extraSmall
//
//        ) {
//            Text("Citylist")
//        }

        LazyColumn {
            items(exapleList.size) { index ->
                ClassRow(
                    exapleList[index]
                )
                { navController.navigate("ExapleList/${exapleList[index]}") }
            }
        }
    }
}

@Composable
fun ClassRow(exapleList: String, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onItemClick() },
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        ClassList(exapleList)
    }
}

@Composable
fun ClassList(cityName: String) {
    Card(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
    ) {

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .background(md_theme_light_errorContainer, RoundedCornerShape(8.dp)),

            ) {
            Text(
                text = cityName,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(16.dp),
                color = Color.Black
            )
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            var exapleList = listOf(
                "ListView & Gridview Demo",
                "Citylist Coustom Grid",
                "Galeery App",
            )
            FirstScreen(
                navController,
                exapleList
                // Add more cities here
            )


        }
//        composable("ListviewScreen") { ListviewScreen() }
        composable("ExapleList/ListView & Gridview Demo") { ListviewScreen() }
        composable("ExapleList/Citylist Coustom Grid") {
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
            CityList(cities)
        }
        var imageUrls = listOf(
            "https://harshil.kachhadiya.info/img/portfolio/1.jpg",
            "https://harshil.kachhadiya.info/img/portfolio/2.jpg",
            "https://harshil.kachhadiya.info/img/portfolio/3.jpg",
            "https://harshil.kachhadiya.info/img/portfolio/4.jpg",
            "https://harshil.kachhadiya.info/img/portfolio/5.jpg",
            // Add more image URLs here
        )
        composable("ExapleList/Galeery App") {

            GalleryActivity(navController, imageUrls)
        }
        composable("imageDetail/{imageResId}") { backStackEntry ->
            val imageResId = backStackEntry.arguments?.getString("imageResId")?.toIntOrNull()
            imageResId?.let {

                FullScreenImageGallery(imageList = imageUrls, navController = navController)
            }
        }
    }
}

@Preview
@Composable
fun YourApp() {
    KotlinDemoTheme {
        App()
    }
}
