package com.example.kotlindemo.JetPackComposed.SigninSignup

import android.content.res.Configuration
import android.content.res.Resources.Theme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.JetPackComposed.ui.theme.KotlinDemoTheme
import com.example.kotlindemo.R

@Composable
fun WelcomeScreen(
    onSignInSignUp: (email : String) -> Unit,
    onSignInAsGuest: () -> Unit
){
    var showBranding by remember { mutableStateOf(true) }

    Surface(modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f, fill = showBranding)
                    .animateContentSize()
            )

            AnimatedVisibility(
                showBranding,
                Modifier.fillMaxWidth()
            ) {
                Branding()
            }

            Spacer(
                modifier = Modifier
                    .weight(1f, fill = showBranding)
                    .animateContentSize()
            )

//            SignInCreateAccount(
//                onSignInSignUp = onSignInSignUp,
//                onSignInAsGuest = onSignInAsGuest,
//                onFocusChange = { focused -> showBranding = !focused },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//            )
        }
    }
}

@Composable
private fun Branding(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 76.dp)
        )
        Text(
            text = stringResource(id = R.string.app_tagline),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier,
    lightTheme: Boolean = LocalContentColor.current.luminance() < 0.5f,
) {
    val assetId = if (lightTheme) {
        R.drawable.baseline_logout_24
    } else {
        R.drawable.baseline_logout_24
    }
    Image(
        painter = painterResource(id = assetId),
        modifier = modifier,
        contentDescription = null
    )
}

//@Composable
//private fun SignInCreateAccount(
//    onSignInSignUp: (email: String) -> Unit,
//    onSignInAsGuest: () -> Unit,
//    onFocusChange: (Boolean) -> Unit,
//    modifier: Modifier = Modifier
//) {
////    val emailState by rememberSaveable(stateSaver = EmailStateSaver) {
////        mutableStateOf(EmailState())
////    }
//    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//        Text(
//            text = stringResource(id = R.string.sign_in_create_account),
//            style = MaterialTheme.typography.bodyMedium,
//            color = MaterialTheme.colorScheme.onSurface.copy(alpha = stronglyDeemphasizedAlpha),
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(top = 64.dp, bottom = 12.dp)
//        )
//        val onSubmit = {
//            if (emailState.isValid) {
//                onSignInSignUp(emailState.text)
//            } else {
//                emailState.enableShowErrors()
//            }
//        }
//        onFocusChange(emailState.isFocused)
//        Email(emailState = emailState, imeAction = ImeAction.Done, onImeAction = onSubmit)
//        Button(
//            onClick = onSubmit,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 28.dp, bottom = 3.dp)
//        ) {
//            Text(
//                text = stringResource(id = R.string.user_continue),
//                style = MaterialTheme.typography.titleSmall
//            )
//        }
//        OrSignInAsGuest(
//            onSignInAsGuest = onSignInAsGuest,
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}

@Preview(name = "Welcome light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Welcome dark theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WelcomeScreenPreview() {
    KotlinDemoTheme {
        WelcomeScreen(
            onSignInSignUp = {},
            onSignInAsGuest = {},
        )
    }
}