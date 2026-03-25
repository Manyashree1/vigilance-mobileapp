package com.manyamad.vigilancevoiceai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.manyamad.vigilancevoiceai.ui.screens.*

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {

        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }

        composable("listening") { ListeningScreen(navController) }
        composable("history") { HistoryScreen() }

        }
    }
