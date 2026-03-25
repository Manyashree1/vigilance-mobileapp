package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // 1. Core Colors
    val deepNavy = Color(0xFF0F172A)
    val deepBlack = Color(0xFF020617)
    val cyanGlow = Color(0xFF38BDF8)

    // 2. Main Entry Animation
    val contentAlpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        contentAlpha.animateTo(1f, tween(1000))
        delay(3000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(deepNavy, deepBlack))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(contentAlpha.value)
        ) {

            // 3. The Analyzer (The "Crazy" part)
            Box(
                modifier = Modifier.size(150.dp),
                contentAlignment = Alignment.Center
            ) {
                // Background "Glow" (No blur needed, just low alpha)
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(cyanGlow.copy(alpha = 0.1f), CircleShape)
                )

                // Dancing Voice Bars
                VoiceVisualizer(cyanGlow)
            }

            Spacer(modifier = Modifier.height(40.dp))

            // 4. Clean High-Tech Text
            Text(
                "VIGILANCE AI",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 6.sp,
                    color = Color.White
                )
            )

            Text(
                "SYSTEM ACTIVE",
                style = MaterialTheme.typography.labelMedium.copy(
                    letterSpacing = 3.sp,
                    color = cyanGlow.copy(alpha = 0.8f)
                )
            )
        }
    }
}

@Composable
fun VoiceVisualizer(color: Color) {
    val infiniteTransition = rememberInfiniteTransition(label = "voice")

    Row(
        modifier = Modifier.fillMaxWidth(0.5f),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // We create 5 bars with different animation delays
        val bars = listOf(0, 1, 2, 1, 0) // Peak in the middle

        bars.forEachIndexed { index, weight ->
            val heightMultiplier by infiniteTransition.animateFloat(
                initialValue = 0.2f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 600 + (index * 100), easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Reverse
                ), label = "bar_$index"
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height((20 + (weight * 40) * heightMultiplier).dp)
                    .background(
                        brush = Brush.verticalGradient(listOf(Color.White, color)),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
        }
    }
}