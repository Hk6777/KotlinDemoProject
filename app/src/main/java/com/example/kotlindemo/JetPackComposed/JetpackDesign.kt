package com.example.kotlindemo.JetPackComposed

import android.annotation.SuppressLint
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.JetPackComposed.RentHouse.Login_rentclass
import com.example.kotlindemo.JetPackComposed.RentHouse.TravoSplash
import com.example.kotlindemo.JetPackComposed.RentHouse.Travo_HomeScreen
import com.example.kotlindemo.JetPackComposed.SigninSignup.UserRepository.user
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme
import com.example.kotlindemo.R

class JetpackDesign : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinDemoTheme {
                // A surface container using the 'background' color from the theme
                YourApp1()
            }
        }
    }
}

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun App1() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }

        composable("splash_screen") {
            TravoSplash(navController)
        }

        composable("main_screen/login") {
            Login_rentclass(navController)

        }

        composable("main_screen") {
            Travo_HomeScreen()

        }

//        composable("detail") { backStackEntry ->
////            val userId = backStackEntry.arguments?.getString("userId")
//
//
//
////                DetailPage(selectedUser = selectedUser)
//
//        }
    }

}

@Composable
fun MainScreen(navController: NavHostController) {
    // Create a button that navigates to the second screen
    Button(
        onClick = { navController.navigate("splash_screen") },
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text("Rent House")
    }
}

@Preview
@Composable
fun YourApp1() {
    KotlinDemoTheme {
        App1()
    }
}
