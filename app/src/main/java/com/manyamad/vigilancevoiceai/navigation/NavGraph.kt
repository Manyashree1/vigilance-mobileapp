package com.manyamad.vigilancevoiceai.navigation

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {

        composable("splash") { SplashScreen(navController) }
        brcomposable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("incoming_call") { IncomingCallScreen(navController) }
        composable("listening") { ListeningScreen(navController) }
        composable("result") { ResultScreen(navController) }
        composable("action") { ActionScreen(navController) }
        composable("payment_warning") { PaymentWarningScreen() }
    }
}