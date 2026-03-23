package com.manyamad.vigilancevoiceai.ui.screens
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B0F1A))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Vigilance AI", color = Color.White, style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(10.dp))

        Text("Your calls are being monitored for fraud",
            color = Color.Gray)

        Spacer(Modifier.height(40.dp))

        Button(
            onClick = { navController.navigate("incoming_call") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simulate Incoming Call")
        }
    }
}