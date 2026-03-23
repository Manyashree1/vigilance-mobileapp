package com.manyamad.vigilancevoiceai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.manyamad.vigilancevoiceai.ui.screens.ActionScreen
import com.manyamad.vigilancevoiceai.ui.screens.HomeScreen
import com.manyamad.vigilancevoiceai.ui.screens.IncomingCallScreen
import com.manyamad.vigilancevoiceai.ui.screens.ListeningScreen
import com.manyamad.vigilancevoiceai.ui.screens.LoginScreen
import com.manyamad.vigilancevoiceai.ui.screens.PaymentWarningScreen
import com.manyamad.vigilancevoiceai.ui.screens.ResultScreen
import com.manyamad.vigilancevoiceai.ui.screens.SplashScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("incoming_call") {
            IncomingCallScreen(navController)
        }

        composable("listening") {
            ListeningScreen(navController)
        }

        composable("result") {
            ResultScreen(navController)
        }

        composable("action") {
            ActionScreen(navController)
        }

        composable("payment_warning") {
            PaymentWarningScreen()
        }
    }
}