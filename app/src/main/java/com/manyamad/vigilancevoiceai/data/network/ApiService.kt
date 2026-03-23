package com.manyamad.vigilancevoiceai.data.network

import com.manyamad.vigilancevoiceai.data.model.AnalysisResult
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("/analyze")
    suspend fun uploadAudio(
        @Part file: MultipartBody.Part
    ): Response<AnalysisResult>
}