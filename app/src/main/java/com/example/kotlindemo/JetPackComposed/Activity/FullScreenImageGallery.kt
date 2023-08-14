package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun FullScreenImageGallery(imageList: List<String>, navController: NavHostController) {

//    LazyColumn(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(imageList) { imageResId ->
//            FullScreenImage(
//                imageResId = imageResId,
//                onBack = { navController.popBackStack() }
//            )
//        }
//    }
    val pagerState = rememberPagerState(
        pageCount = imageList.size
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        FullScreenImage(
            imageResId = imageList[page],
            onBack = { navController.popBackStack() }
        )
    }
//    val pagerState = rememberPagerState(
//        pageCount = imageList.size,
//        initialOffscreenLimit = 2
//    )
//
//    VerticalPager(
//        state = pagerState,
//        modifier = Modifier.fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically
//    ) { page ->
//        FullScreenImage(
//            imageResId = imageList[page]
//        ) { navController.popBackStack() }
//    }
}




@Composable
fun FullScreenImage(imageResId: String, onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        GlideImage(
            imageModel = { imageResId },
            imageOptions = ImageOptions(
                contentDescription = null,
                contentScale = ContentScale.Fit
            ),
            modifier = Modifier.fillMaxSize()
        )

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
}

@Composable
fun SquareImageItem(imageResId: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        GlideImage(
            imageModel = { imageResId },
            imageOptions = ImageOptions(
                contentDescription = null,
                contentScale = ContentScale.Crop
            ),
            modifier = Modifier
                .clickable(onClick = onClick)
                .aspectRatio(1f)
                .fillMaxWidth()
        )
    }
}

@Composable
fun SquareImageGallery(imageList: List<Int>, navController: NavHostController) {
    LazyColumn {
        items(imageList) { imageResId ->
            SquareImageItem(imageResId = imageResId) {
                navController.navigate("imageDetail/$imageResId")
            }
        }
    }
}



