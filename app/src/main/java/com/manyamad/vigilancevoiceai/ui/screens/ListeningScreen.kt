package com.manyamad.vigilancevoiceai.ui.screens

import android.content.Context
import android.net.Uri
import android.util.Log
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
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream

@Composable
fun ListeningScreen(navController: NavController) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->

        uri?.let {
            scope.launch {
                try {
                    isLoading = true

                    Log.d("API_DEBUG", "🔥 API CALL STARTED")

                    val file = uriToFile(uri, context)

                    Log.d("API_DEBUG", "FILE READY")

                    val requestFile = file.asRequestBody("audio/wav".toMediaTypeOrNull())

                    val body = MultipartBody.Part.createFormData(
                        "file",   // 🔥 MUST MATCH BACKEND
                        "audio.wav",
                        requestFile
                    )

                    val response = RetrofitInstance.api.verifyCall(body)

                    Log.d("API_DEBUG", "CODE: ${response.code()}")

                    if (response.isSuccessful) {
                        Log.d("API_DEBUG", "BODY: ${response.body()}")
                    } else {
                        Log.d("API_DEBUG", "ERROR: ${response.errorBody()?.string()}")
                    }

                } catch (e: Exception) {
                    Log.d("API_DEBUG", "EXCEPTION: ${e.message}")
                } finally {
                    isLoading = false
                }
            }
        }
    }

    // UI
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Vigilance Voice AI",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {
                launcher.launch("audio/*")
            }) {
                Text("📁 Upload Audio")
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}

// 🔥 FILE CONVERTER (IMPORTANT)
fun uriToFile(uri: Uri, context: Context): File {
    val file = File(context.cacheDir, "temp_audio.wav")

    val inputStream = context.contentResolver.openInputStream(uri)
    val outputStream = FileOutputStream(file)

    inputStream?.copyTo(outputStream)

    inputStream?.close()
    outputStream.close()

    return file
}