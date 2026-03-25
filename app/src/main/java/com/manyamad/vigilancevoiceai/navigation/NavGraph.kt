package com.manyamad.vigilancevoiceai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.manyamad.vigilancevoiceai.ui.screens.*

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("listening") {
            ListeningScreen(navController)
        }

        composable("history") {
            HistoryScreen()
        }

        // 🔥 NEW: LOADING SCREEN
        composable(
            "loading/{finalRisk}/{scamIntent}/{transcript}/{recommendation}"
        ) { backStackEntry ->

            val finalRisk =
                backStackEntry.arguments?.getString("finalRisk") ?: ""

            val scamIntent =
                backStackEntry.arguments?.getString("scamIntent") ?: ""

            val transcript =
                backStackEntry.arguments?.getString("transcript") ?: ""

            val recommendation =
                backStackEntry.arguments?.getString("recommendation") ?: ""

            LoadingScreen(
                navController,
                finalRisk,
                scamIntent,
                transcript,
                recommendation
            )
        }

        // 🔥 NEW: RESULT SCREEN
        composable(
            "result/{finalRisk}/{scamIntent}/{transcript}/{recommendation}"
        ) { backStackEntry ->

            val finalRisk =
                backStackEntry.arguments?.getString("finalRisk") ?: ""

            val scamIntent =
                backStackEntry.arguments?.getString("scamIntent") ?: ""

            val transcript =
                backStackEntry.arguments?.getString("transcript") ?: ""

            val recommendation =
                backStackEntry.arguments?.getString("recommendation") ?: ""

            ResultScreen(
                finalRisk,
                scamIntent,
                transcript,
                recommendation
            )
        }
    }
}
