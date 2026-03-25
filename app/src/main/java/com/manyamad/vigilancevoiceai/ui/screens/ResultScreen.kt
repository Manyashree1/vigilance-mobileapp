package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
    finalRisk: String,
    scamIntent: String,
    transcript: String,
    recommendation: String
) {

    val isHighRisk = finalRisk.uppercase() == "HIGH"

    val bgGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF020617),
            Color(0xFF0F172A)
        )
    )

    val riskColor = if (isHighRisk) Color(0xFFEF4444) else Color(0xFF22C55E)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgGradient)
            .padding(20.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // 🔥 TITLE
            Text(
                text = "Analysis Result",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            // 🚨 RISK CARD
            Card(
                colors = CardDefaults.cardColors(containerColor = riskColor),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Text(
                        text = "Risk Level",
                        color = Color.White
                    )

                    Text(
                        text = finalRisk,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            // 📞 SCAM TYPE
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "Detected Scam",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = scamIntent)
                }
            }

            // 📝 TRANSCRIPT
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "Transcript",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = transcript)
                }
            }

            // 💡 RECOMMENDATION
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "What You Should Do",
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(text = recommendation)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 🔙 BACK BUTTON
            Button(
                onClick = { /* navigate back handled in nav */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Back to Home")
            }
        }
    }
}