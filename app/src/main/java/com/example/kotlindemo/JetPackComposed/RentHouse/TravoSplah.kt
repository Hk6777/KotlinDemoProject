package com.example.kotlindemo.JetPackComposed.RentHouse

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.placeholder
import com.example.kotlindemo.JetPackComposed.ui.theme.*
import com.example.kotlindemo.R
import kotlinx.coroutines.delay


@Composable
fun TravoSplash(navController: NavController) {

    LaunchedEffect(true) {
        // Introduce a delay for the splash screen duration (e.g., 2 seconds)
        delay(1000)
        navController.navigate("main_screen/login") {
            popUpTo("splash_screen") {
                inclusive = true
            }
        }
    }

    val alpha: Float by animateFloatAsState(targetValue = 1f)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_onPrimary),
        contentAlignment = Alignment.Center

    ) {
//        Box(
//            modifier = Modifier
//                .background(md_theme_dark_surfaceTint)
//                .padding(16.dp)
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {

            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .alpha(alpha),
                text = "Travo",
                fontSize = 50.sp,
                fontWeight = Bold,
                color = Color.Black
            )
//        }


    }


}


