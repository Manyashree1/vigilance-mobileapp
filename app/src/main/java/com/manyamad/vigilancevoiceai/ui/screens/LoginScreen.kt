package com.manyamad.vigilancevoiceai.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var userType by remember { mutableStateOf("Select User Type") }
    var expanded by remember { mutableStateOf(false) }

    val userTypes = listOf("Rural User", "Elderly", "Student", "Professional")

    val isValid = name.isNotBlank() && phone.length == 10 && userType != "Select User Type"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Welcome 👋",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        // NAME
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // PHONE
        OutlinedTextField(
            value = phone,
            onValueChange = {
                if (it.length <= 10) phone = it.filter { c -> c.isDigit() }
            },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // USER TYPE DROPDOWN
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {

            OutlinedTextField(
                value = userType,
                onValueChange = {},
                readOnly = true,
                label = { Text("User Type") },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                userTypes.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            userType = it
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // CONTINUE BUTTON
        Button(
            onClick = {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            },
            enabled = isValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }
    }
}