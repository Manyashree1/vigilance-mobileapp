package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun IncomingCallScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(60.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Incoming Call", color = Color.Gray)
            Text("Bank Support", color = Color.White, fontSize = 28.sp)
            Text("+91 98XXXXXX12", color = Color.Gray)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) { Text("Decline") }

            Button(
                onClick = { navController.navigate("listening") },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) { Text("Accept") }
        }
    }
}