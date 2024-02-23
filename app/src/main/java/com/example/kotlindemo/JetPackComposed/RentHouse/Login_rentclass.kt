package com.example.kotlindemo.JetPackComposed.RentHouse

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlindemo.R

//@Preview
@Composable
fun Login_rentclass(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .weight(1f)
        ) {
            // Background image layer
            Image(
                painter = painterResource(id = R.drawable.home_background),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {


                Text(
                    text = "Discover Your",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Dream Home",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }


        // Content layer
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .padding(16.dp)
                .weight(1f)
        ) {


            Row {

                Button(
                    onClick = { navController.navigate("main_screen") },
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text("Login", color = Color.White)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { /* Handle sign up */ },
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    border = BorderStroke(0.5.dp, Color.Gray)
                ) {
                    Text("Sign Up", color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(0.8.dp)
                        .background(Color.Gray)
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text("or Login with", color = Color.Gray)

                Spacer(modifier = Modifier.width(10.dp))

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(0.5.dp)
                        .background(Color.Gray)
                        .align(Alignment.CenterVertically)
                )
            }



            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle sign up */ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.8.dp, Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_logo),
                    contentDescription = "Android Icon",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    "Continue with Google",
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.width(10.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle sign up */ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.5.dp, Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Android Icon",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    "Continue with Apple",
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.width(10.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle sign up */ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                border = BorderStroke(0.5.dp, Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Android Icon",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    "Continue with Facebook",
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.width(10.dp))
            }

        }

    }
}