package com.manyamad.vigilancevoiceai.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manyamad.vigilancevoiceai.data.network.RetrofitInstance
import com.manyamad.vigilancevoiceai.utils.prepareFile
import com.manyamad.vigilancevoiceai.utils.uriToFile
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ListeningScreen(navController: NavController) {

    var status by remember { mutableStateOf("Listening...") }

    LaunchedEffect(Unit) {
        delay(2000)
        status = "Analyzing voice patterns..."

        delay(2000)
        status = "Detecting scam keywords..."

        delay(2000)
        navController.navigate("result")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("🎧 Live Call Active", color = Color.Green)

        Spacer(Modifier.height(20.dp))

        Text(status, color = Color.White)

        Spacer(Modifier.height(30.dp))

        CircularProgressIndicator(color = Color.Cyan)
    }
}