package com.example.kotlindemo.JetPackComposed.Activity

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GalleryActivity(navController: NavController, imageList: List<String>) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        Text(
            text = "Gallery App",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
//        Modifier.height(16.dp)
        LazyVerticalGrid(
            GridCells.Fixed(3),
            contentPadding = PaddingValues(1.dp),

//            columns = GridCells.Adaptive(minSize = 120.dp)
        ) {

            items(imageList.size) { image ->
                ImageItem(imageList[image]){
                    navController.navigate("imageDetail/$image")
                }
            }

        }
    }

}


@Composable
fun ImageItem(imageUrl: String, onItemClick: () -> Unit) {
    Log.e("hhhhh", "ImageItem: " + imageUrl)
    GlideImage(
        imageModel = { imageUrl }, // loading a network image using an URL.
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
//            alignment = Alignment.Center

        ),
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .padding(2.dp)
            .clickable { onItemClick() },

    )

}


