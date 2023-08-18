package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MatrialDesignDemos2() {


    var date1 by remember {
        mutableStateOf(value = false)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.size(30.dp))
            coustomProgressBar()
        }

        DownloadProgressBar()

        Button(onClick = { date1 = true }) {

            Text(text = "Date Picker Demo1")

        }
        var datePickerState =
            rememberDatePickerState(initialDisplayedMonthMillis = 1578096000000)

        if (date1) {
            DatepickerDemo1(onDismiss = { date1 = false }, datePickerState)
        }

        val timestamp = System.currentTimeMillis()
        val formattedDate = datePickerState.selectedDateMillis?.let { TimestampToDateUsingDate(it) }

        Text(text = "Selected date timestamp : ${formattedDate ?: "no selection"}")


    }

}


@Composable
fun TimestampToDateUsingDate(timestamp: Long): String {
    val date = Date(timestamp)
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(date)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatepickerDemo1(onDismiss: () -> Unit, datePickerState: DatePickerState) {


    Dialog(onDismissRequest = { onDismiss() }) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text("Select a Date") },
            confirmButton = {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(text = "OK")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(text = "Cancel")
                }
            },
            text = {
                Column {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {

                        DatePicker(state = datePickerState)

//
                    }
                }

            }
        )
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


