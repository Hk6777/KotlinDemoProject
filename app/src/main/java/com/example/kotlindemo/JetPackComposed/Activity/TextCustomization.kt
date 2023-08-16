package com.example.kotlindemo.JetPackComposed.Activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme
import com.example.kotlindemo.R

@Composable
fun TextCustomization() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        CoustomText()
        CoustomText1()
        CoustomText3()

        Text(text = "Selction and DisSlection Text", color = MaterialTheme.colorScheme.primary)
        CoustomText4()

        Text(
            text = "Super and Sub Text",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
        )

        SuperScriptText(normalText = "Harshil", superText = "2")

        ExpandableCard(
            title = stringResource(id = R.string.app_name),
            description = stringResource(id = R.string.dummy_text)
        )


    }
}

@Composable
fun CoustomText() {
    Text(
        text = stringResource(id = R.string.app_name),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
            .width(300.dp),
        color = Color.White,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun CoustomText1() {
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("A")
                }

                append("B")
                append("C")
                append("D")
                append("E")
            }
        }, modifier = Modifier
            .width(200.dp)
            .padding(10.dp)
    )
}

@Composable
fun CoustomText3() {
    Text(
        text = "Hello World!".repeat(20), maxLines = 4, overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun CoustomText4() {


    SelectionContainer {
        Column {
            Text(text = "Hello World!")
            DisableSelection {
                Text(text = "Hello World!")
            }
            Text(text = "Hello World!")
        }
    }


}

@Composable
fun SuperScriptText(
    normalText: String,
    normalTextFontSize: TextUnit = 30.sp,
    superText: String,
    superTextFontSize: TextUnit = 10.sp,
    superTextFontWeight: FontWeight = FontWeight.Normal
) {
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalTextFontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = superTextFontSize,
                fontWeight = superTextFontWeight,
                baselineShift = BaselineShift.Subscript //SuperScript = Upper, SubSciprt  = Lower
            )
        ) {
            append(superText)
        }
    })
}


@Preview
@Composable
fun DefaultPreview() {
    KotlinDemoTheme() {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            CoustomText()
            CoustomText1()
            CoustomText3()

            Text(text = "Selction and DisSlection Text", color = MaterialTheme.colorScheme.primary)
            CoustomText4()

            Text(
                text = "Super and Sub Text",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
            )

            SuperScriptText(normalText = "Harshil", superText = "2")

        }

    }
}