package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_errorContainer
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_primary


@Composable
fun CityList(cities: List<String>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        TextView(text = "City List Example")
        CityListView(cities, "1")
        TextView(text = "Sample 1")
        CityListView(cities, "2")
    }
}

@Composable
fun CityListView(cities: List<String>, Status: String) {

    val maxWidth = 315.dp // Set the maximum width for each row
    val spacing = 8.dp // Set the spacing between items

    var currentRow = mutableListOf<String>()
    var currentWidth = 0.dp

    cities.forEach { city ->
        val cityWidth = (city.length * 12).dp // Adjust the width based on your content

        if (currentWidth + cityWidth + spacing <= maxWidth) {
            currentRow.add(city)
            currentWidth += cityWidth + spacing
        } else {
            CityRow(currentRow, Status)
            currentRow = mutableListOf(city)
            currentWidth = cityWidth + spacing
        }
    }

    if (currentRow.isNotEmpty()) {
        CityRow(currentRow, Status)
    }


}


@Composable
fun TextView(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun CityRow(cities: List<String>, Status: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        cities.forEach { city ->
            CityCard(city, Status)
        }


    }
}

@Composable
fun CityCard(cityName: String, status: String) {
    Card(
        modifier = Modifier
            .height(50.dp)
    ) {

        val backgroundColor = if (status.equals("1")) Color.White else md_theme_light_errorContainer
        val borderColor = if (status.equals("1")) md_theme_light_primary else md_theme_light_errorContainer

        Box(

            modifier = Modifier
                .background(backgroundColor, RoundedCornerShape(8.dp))
                .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(8.dp)),

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






