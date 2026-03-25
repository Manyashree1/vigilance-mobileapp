package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Vigilance AI", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate("listening") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🎙 Analyze Audio")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate("history") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📜 View History")
        }
    }
}