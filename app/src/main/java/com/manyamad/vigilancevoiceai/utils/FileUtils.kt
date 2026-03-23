package com.manyamad.vigilancevoiceai.utils

import android.content.Context
import android.net.Uri
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

fun uriToFile(context: Context, uri: Uri): File {
    val inputStream = context.contentResolver.openInputStream(uri)!!
    val file = File(context.cacheDir, "temp_audio.wav")
    file.outputStream().use { output ->
        inputStream.copyTo(output)
    }
    return file
}

fun prepareFile(file: File): MultipartBody.Part {
    val requestFile = file.asRequestBody()
    return MultipartBody.Part.createFormData("file", file.name, requestFile)
}