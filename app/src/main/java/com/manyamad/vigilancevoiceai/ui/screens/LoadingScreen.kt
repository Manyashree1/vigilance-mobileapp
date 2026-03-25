package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(navController: NavController, backStackEntry: NavBackStackEntry) {

    val risk = backStackEntry.arguments?.getString("risk") ?: ""
    val intent = backStackEntry.arguments?.getString("intent") ?: ""
    val transcript = backStackEntry.arguments?.getString("transcript") ?: ""
    val rec = backStackEntry.arguments?.getString("rec") ?: ""

    var step by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        repeat(3) {
            delay(1000)
            step++
        }
        navController.navigate("result/$risk/$intent/$transcript/$rec")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("🔍 AI Analyzing...", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        if (step >= 1) Text("✔ Transcribing...")
        if (step >= 2) Text("✔ Detecting intent...")
        if (step >= 3) Text("✔ Checking fraud...")

        Spacer(modifier = Modifier.height(20.dp))

        CircularProgressIndicator()
    }
}