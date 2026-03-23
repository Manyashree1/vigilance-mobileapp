package com.manyamad.vigilancevoiceai.data.model

data class AnalysisResult(
    val risk: String,
    val score: Double,
    val intent: String,
    val deepfake: Boolean
)