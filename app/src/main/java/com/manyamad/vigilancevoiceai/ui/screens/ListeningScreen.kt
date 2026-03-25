package com.manyamad.vigilancevoiceai.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.manyamad.vigilancevoiceai.data.network.RetrofitInstance
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@Composable
fun ListeningScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->

        uri?.let {
            val file = File(it.path ?: "")
            val body = MultipartBody.Part.createFormData(
                "file",
                file.name,
                file.asRequestBody("audio/*".toMediaTypeOrNull())
            )

            scope.launch {
                isLoading = true

                val response = RetrofitInstance.api.verifyCall(body)

                if (response.isSuccessful) {
                    val data = response.body()

                    navController.navigate(
                        "loading/${data?.finalRisk}/${data?.scamIntent}/${data?.transcriptEnglish}/${data?.recommendation}"
                    )
                }

                isLoading = false
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Vigilance Voice AI", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(10.dp))
        Text("Protecting you from scam calls")

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { launcher.launch("audio/*") },
            modifier = Modifier.size(180.dp)
        ) {
            Text("🎙️", style = MaterialTheme.typography.headlineLarge)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { launcher.launch("audio/*") }) {
            Text("📁 Upload Recording")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate("loading/HIGH/Loan Scam/Fake call detected/Do not share OTP")
        }) {
            Text("🚨 Live Monitoring (Demo)")
        }
        Button(onClick = { navController.navigate("history") }) {
            Text("📜 View History")
        }

        if (isLoading) {
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator()
        }
    }
}