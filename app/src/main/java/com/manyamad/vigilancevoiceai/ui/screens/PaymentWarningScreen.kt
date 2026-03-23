package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PaymentWarningScreen() {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("₹50,000 Request", color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        Text("⚠️ SCAM DETECTED", color = Color.Red)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {}) {
            Text("Cancel")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {}) {
            Text("Proceed Anyway")
        }
    }
}