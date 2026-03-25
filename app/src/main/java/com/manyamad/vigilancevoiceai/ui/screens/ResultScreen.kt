package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.*

@Composable
fun ResultScreen(navController: NavController, backStackEntry: NavBackStackEntry) {

    val risk = backStackEntry.arguments?.getString("risk") ?: ""
    val intent = backStackEntry.arguments?.getString("intent") ?: ""
    val transcript = backStackEntry.arguments?.getString("transcript") ?: ""
    val rec = backStackEntry.arguments?.getString("rec") ?: ""

    val isHigh = risk == "HIGH"
    val bg = if (isHigh) Color(0xFFFFCDD2) else Color(0xFFC8E6C9)

    Column(
        modifier = Modifier.fillMaxSize().background(bg).padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            if (isHigh) "⚠️ SCAM DETECTED" else "✅ SAFE CALL",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card {
            Column(Modifier.padding(16.dp)) {
                Text("Intent: $intent")
                Text("Transcript: $transcript")
                Text("Advice: $rec")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (isHigh) {
            Button(onClick = {}) { Text("📞 Block") }
            Button(onClick = {}) { Text("🚨 Alert") }
            Button(onClick = {}) { Text("📤 Share") }
        }
    }
}