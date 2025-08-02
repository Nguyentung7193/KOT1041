package com.example.kot1041_app.lap.lap5

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun Lap5b1() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var loginInfo by remember { mutableStateOf("") }

    fun saveLoginInfo(email: String, password: String) {
        loginInfo = "Email: $email\nPassword: $password"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        // Card chứa các thành phần
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.medium),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = MaterialTheme.shapes.medium,
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "Đăng nhập",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Mật khẩu") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        saveLoginInfo(email, password)
                        showDialog = true
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Đăng nhập")
                }
            }
        }
    }

    // Dialog hiển thị thông tin đăng nhập
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("Thông tin đăng nhập:", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(loginInfo)
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { showDialog = false },
                        modifier = Modifier.align(androidx.compose.ui.Alignment.End)
                    ) {
                        Text("Đóng")
                    }
                }
            }
        }
    }
}
