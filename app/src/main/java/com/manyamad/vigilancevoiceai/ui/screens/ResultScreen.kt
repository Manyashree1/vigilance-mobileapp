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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.manyamad.vigilancevoiceai.data.model.AnalysisResult

@Composable
fun ResultScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("⚠️ HIGH RISK", color = Color.Red)
        Text("Scam Probability: 92%", color = Color.White)
        Text("Detected: OTP Scam", color = Color.Gray)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate("action")
        }) {
            Text("Take Action")
        }
    }
}