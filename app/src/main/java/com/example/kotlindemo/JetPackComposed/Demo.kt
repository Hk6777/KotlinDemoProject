package com.example.kotlindemo.JetPackComposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme

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
fun FirstScreen (navController: NavController) {
    Column(
    modifier = Modifier.padding(16.dp)
    ) {
        Button(
            onClick = {
                // Navigate to the second screen when the button is clicked
                navController.navigate("secondScreen")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Go to Second Screen")
        }
    }
}

@Composable
fun SecondScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Second Screen Content")
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "firstScreen") {
        composable("firstScreen") { FirstScreen(navController) }
        composable("secondScreen") { SecondScreen() }
    }
}
@Preview
@Composable
fun YourApp() {
    KotlinDemoTheme {
        App()
    }
}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier,
//
//
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    KotlinDemoTheme {
//        Column {
//            Greeting("Kaushal")
//            Greeting("Harshil")
//        }
//
//    }
//}