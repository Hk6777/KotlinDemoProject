package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.kotlindemo.JetPackComposed.ui.theme.Shapes
import com.example.kotlindemo.JetPackComposed.ui.theme.grad_color1
import com.example.kotlindemo.JetPackComposed.ui.theme.grad_color2
import com.example.kotlindemo.R


@Preview
@Composable
fun DesignPage3() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        GoogleButton(onClicked = { Unit })
        Spacer(modifier = Modifier.size(10.dp))
        ImageLoading()
        Spacer(modifier = Modifier.size(15.dp))
        EditPasswordVisibility()
        Spacer(modifier = Modifier.size(15.dp))
        GardiantButtonView(
            text = "Button",
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    grad_color1,
                    grad_color2
                )
            )

        ) {}
        RoundshapeIcon()
        SwichView()
    }

}

@Composable
fun SwichView() {

    var check by remember { mutableStateOf(true) }

    Switch(
        checked = check,
        onCheckedChange = { check = it },
        modifier = Modifier.semantics { contentDescription = "Demo" })

}

@Composable
fun RoundshapeIcon() {

    FilledIconButton(
        onClick = { /* doSomething() */ },
        colors = IconButtonDefaults.filledIconButtonColors(grad_color2)
    ) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description", tint = Color.White)
    }
}


@Composable
fun GardiantButtonView(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClicked: () -> Unit
) {

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(vertical = 8.dp, horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)

        }


    }

}

@Composable
fun EditPasswordVisibility() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var password by remember { mutableStateOf("") }
        var passwordVisiblity by remember { mutableStateOf(false) }

        val icon = if (passwordVisiblity) {
            painterResource(id = R.drawable.baseline_visibility_24)
        } else {
            painterResource(id = R.drawable.baseline_visibility_off_24)
        }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
            trailingIcon = {
                IconButton(onClick = { passwordVisiblity = !passwordVisiblity }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility on"
                    )
                }
            },
            visualTransformation = if (passwordVisiblity) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }

}


@Composable
fun ImageLoading() {

    Column {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(150.dp),
        ) {
            val painter =
                rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https://avatars.githubusercontent.com/u/100499777?v=4")
                        .apply(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.placeholder)
                            error(R.drawable.errorplaceholder)
                            crossfade(1000)
                            transformations(

                                CircleCropTransformation()
                            )
                        }).build(

                        )
                )
            Image(painter = painter, contentDescription = "Logo Image")


        }
    }

}

@Composable
fun GoogleButton(
    onClicked: () -> Unit,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account...",
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    icon: Int = R.drawable.ic_google_logo,
) {
    var clicked by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.clickable {
            clicked = !clicked
            onClicked()
        },
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor
    ) {

        Row(
            modifier = Modifier
                .padding(12.dp, 12.dp, 16.dp, 12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Google Button",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else text)

            if (clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor

                )
            }

        }

    }
}

