package com.manyamad.vigilancevoiceai.data.model

data class AnalysisResult(
    val final_risk: String,
    val scam_intent: String,
    val transcript_english: String,
    val recommendation: String
)