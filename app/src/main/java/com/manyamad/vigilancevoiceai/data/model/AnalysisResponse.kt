package com.manyamad.vigilancevoiceai.data.model

import com.google.gson.annotations.SerializedName

data class AnalysisResponse(
    @SerializedName("final_risk")
    val finalRisk: String,

    @SerializedName("scam_intent")
    val scamIntent: String,

    @SerializedName("transcript_english")
    val transcriptEnglish: String,

    @SerializedName("recommendation")
    val recommendation: String
)