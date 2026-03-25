package com.manyamad.vigilancevoiceai.data.network

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("verify-call")   // 🔥 EXACT ENDPOINT (VERY IMPORTANT)
    suspend fun verifyCall(
        @Part file: MultipartBody.Part
    ): Response<String>
}