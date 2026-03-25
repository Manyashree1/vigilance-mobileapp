package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    navController: NavController,
    finalRisk: String,
    scamIntent: String,
    transcript: String,
    recommendation: String
) {

    val deepBlue = Color(0xFF0F172A)
    val black = Color(0xFF020617)
    val cyan = Color(0xFF38BDF8)

    val steps = listOf(
        "Analyzing voice...",
        "Detecting scam patterns...",
        "Checking emotional stress...",
        "Generating report..."
    )

    var currentStep by remember { mutableStateOf(0) }

    val alphaAnim = remember { Animatable(0f) }

    LaunchedEffect(Unit) {

        alphaAnim.animateTo(1f, tween(800))

        for (i in steps.indices) {
            currentStep = i
            delay(1200)
        }

        delay(800)

        // 🚀 Navigate to result screen
        navController.navigate(
            "result/$finalRisk/$scamIntent/$transcript/$recommendation"
        ) {
            popUpTo("loading") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(deepBlue, black))
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(alphaAnim.value)
        ) {

            // 🔵 Animated Indicator
            CircularProgressIndicator(
                color = cyan,
                strokeWidth = 5.dp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // 🔥 Dynamic Step Text
            Text(
                text = steps[currentStep],
                color = Color.White,
                fontSize = 18.sp,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "AI Processing...",
                color = cyan,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
        }
    }
}