package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HistoryScreen() {

    val history = listOf(
        "HIGH - Loan Scam",
        "LOW - Normal Call",
        "MEDIUM - Suspicious"
    )

    Column(Modifier.padding(20.dp)) {

        Text("📜 History", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(10.dp))

        history.forEach {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(it, Modifier.padding(10.dp))
            }
        }
    }
}