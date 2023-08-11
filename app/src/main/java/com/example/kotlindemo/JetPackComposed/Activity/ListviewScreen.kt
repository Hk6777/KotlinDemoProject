package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.JetPackComposed.ui.theme.Shapes
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_primaryContainer
import com.example.kotlindemo.JetPackComposed.ui.theme.*

@Preview
@Composable
fun ListviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Static List Example",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //LazyColumn doing in one coloumn & LazyVerticalGrid for multiple coloumn
        LazyVerticalGrid(
            GridCells.Fixed(3), // Set the number of columns here
            modifier = Modifier.fillMaxSize()
        ) {
            items(20) { index ->
                ListItem("Item $index", getColorForIndex(index), Color.White)
            }
        }

    }
}

@Composable
fun ListItem(text: String, cardColor: Color, textColor: Color) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)// Ensures padding color matches card's background color
            .background(cardColor, RoundedCornerShape(15)),

        ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
    }

}

fun getColorForIndex(index: Int): Color {
    val colors = listOf(
        md_theme_light_surfaceTint,
        md_theme_light_primaryContainer,
        md_theme_light_tertiary,
        md_theme_light_tertiaryContainer,
        md_theme_light_error,
        md_theme_dark_error,
        md_theme_dark_errorContainer,
        md_theme_dark_onError,
        md_theme_dark_onSurface,
        md_theme_dark_inversePrimary
    )

    return colors[index % colors.size]
}