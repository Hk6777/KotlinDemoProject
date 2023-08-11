package com.example.kotlindemo.JetPackComposed

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.JetPackComposed.Destination.SURVEY_ROUTE
import com.example.kotlindemo.JetPackComposed.Destination.WELCOME_ROUTE
import com.example.kotlindemo.JetPackComposed.SigninSignup.WelcomeRoute


object Destination {
    const val WELCOME_ROUTE = "welcome"
    const val SIGN_UP_ROUTE = "signup/{email}"
    const val SIGN_IN_ROUTE = "signin/{email}"
    const val SURVEY_ROUTE = "survey"
    const val SURVEY_RESULT_ROUTE = "surveyresults"
}

@Preview
@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = WELCOME_ROUTE) {
        composable(WELCOME_ROUTE) {
            WelcomeRoute(
                onNavigationSignin = {
                    navController.navigate("signin/$it")
                },
                onNavigationSignup = {
                    navController.navigate("signup/$it")
                },
                onSigninGuest = {
                    navController.navigate(SURVEY_ROUTE)
                },
            )
        }

    }

}