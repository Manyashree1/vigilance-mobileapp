package com.manyamad.vigilancevoiceai.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manyamad.vigilancevoiceai.data.network.RetrofitInstance
import com.manyamad.vigilancevoiceai.utils.prepareFile
import com.manyamad.vigilancevoiceai.utils.uriToFile
import kotlinx.coroutines.launch

@Composable
fun ListeningScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("result")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("🎧 Listening...", color = Color.White)
        Text("🧠 Analyzing...", color = Color.Cyan)
        Text("⚠️ Detecting Scam...", color = Color.Red)
    }
}