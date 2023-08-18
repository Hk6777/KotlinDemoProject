package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MatrialDesignDemos2() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.size(30.dp))
            coustomProgressBar()
        }

        DownloadProgressBar()


    }

}

@Composable
fun DownloadProgressBar() {

    var progress by remember {
        mutableStateOf(0.1f)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        OutlinedButton(
            onClick = {
                if (progress < 1f) {
                    progress += 0.1f
                } else {
                    progress = 0f // just for reset progressbar
                }
            }
        ) {
            Text(text = "Download")
        }

    }
}


val progressBreakpoints = setOf(25, 50, 75)

@Composable
fun coustomProgressBar() {

    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )


    Row {

        CircularProgressIndicator(progress = animatedProgress)
        Spacer(modifier = Modifier.size(40.dp))
        OutlinedButton(
            onClick = { if (progress < 1f) progress += 0.1f else progress = 0f },
            modifier = Modifier.semantics {
                val progressPercent = (progress * 100).toInt()

                if (progressPercent in progressBreakpoints) {
                    stateDescription = "Progress $progressPercent%"
                } else {
                    stateDescription = "null" // just for progressbar reset
                }
            }) {
            Text(text = "Click")
        }

    }

}


