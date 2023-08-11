package com.example.kotlindemo.JetPackComposed.SigninSignup

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WelcomeRoute(
    onNavigationSignin : (email : String) -> Unit,
    onNavigationSignup : (email : String) -> Unit,
    onSigninGuest : () -> Unit,
){
    val welcomeViewModel : WelcomeViewModel = viewModel(factory = WelcomeViewModel.WelcomeViewModelFactory())
        WelcomeScreen(
            onSignInSignUp = { email ->
                welcomeViewModel.handleContinue(
                    email = email,
                    onNavigateToSignIn = onNavigationSignin,
                    onNavigateToSignUp = onNavigationSignup,
                )
            },
            onSignInAsGuest = {
                welcomeViewModel.signInAsGuest(onSigninGuest)
            },
        )
    }

