package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ActionScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Recommended Actions", color = Color.White)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("🚫 Block Number")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("📞 Report to Cybercrime")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("👨‍👩‍👧 Alert Family")
        }
    }
}