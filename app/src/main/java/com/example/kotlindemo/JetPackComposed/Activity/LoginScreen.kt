package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.End
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme.colors
import com.example.kotlindemo.JetPackComposed.ui.theme.MontserratFontFamily
import com.example.kotlindemo.JetPackComposed.ui.theme.facebook_color
import com.example.kotlindemo.JetPackComposed.ui.theme.gray_500
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_dark_background
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_background
import com.example.kotlindemo.R


@Preview
@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(16.dp)

    ) {

        Image(
            painter = painterResource(id = R.drawable.mobile_login_rafiki),
            contentDescription = null // Content description for accessibility
        )
        Text(
            text = "Login", style = TextStyle(
                fontFamily = MontserratFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 1.5.sp
            )
        )
        OutlinedTextField(
            value = email,
            onValueChange = { newText ->
                email = newText
            },
            label = { Text("Username") },
            isError = !isValidEmail(email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 0.dp, 0.dp),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { newText ->
                password = newText
            },
            label = { Text("Password") },
            isError = !isValidPassword(password),
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_password_24),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        )

        Text(
            text = "Forgot Password?", style = TextStyle(
                fontFamily = MontserratFontFamily,
                color = facebook_color,
                fontSize = 17.sp,
                letterSpacing = 0.sp
            ),
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)

        )

        Button(
            onClick = { /* Handle button click here */ },
            colors = ButtonDefaults.buttonColors(facebook_color),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(text = "Custom Button", color = Color.White, fontSize = 20.sp)
        }

        Text(
            text = "Or", style = TextStyle(
                fontFamily = MontserratFontFamily,
                fontSize = 15.sp,
                lineHeight = 40.sp,
            ),
            modifier = Modifier
                .padding(top = 10.dp)
                .align(CenterHorizontally)
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(gray_500),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "google icon",
                modifier = Modifier.size(30.dp).padding(5.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Google Login", color = Color.Black, fontSize = 20.sp)


        }

    }


}

