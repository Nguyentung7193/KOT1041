// com.example.kot1041_app.navigate.AppNavigation.kt

package com.example.kot1041_app.navigate

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.example.kot1041_app.lap.lap4.Lap4b1
import com.example.kot1041_app.lap.lap4.Lap4b2
import com.example.kot1041_app.lap.lap4.Lap4b3
import com.example.kot1041_app.lap.lap3.StudentProfileScreen
import com.example.kot1041_app.lap.lap5.Lap5b1
import com.example.kot1041_app.lap.lap5.Lap5b2
import com.example.kot1041_app.lap.lap5.Lap5b3
import com.example.kot1041_app.screens.menu.BottomNavBar

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var fabContent by remember { mutableStateOf<(@Composable () -> Unit)?>(null) }
    var showBottomBar by remember { mutableStateOf(true) }

    Scaffold(
        floatingActionButton = {
            fabContent?.invoke()
        },
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "lap4b1",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("lap4b1") {
                showBottomBar = true
                fabContent = null
                Lap4b1()
            }

            composable("lap4b2") {
                showBottomBar = true
                fabContent = {null}
                Lap4b2()
            }

            composable("lap4b3") {
                val context = LocalContext.current
                showBottomBar = true
                fabContent = {
                    FloatingActionButton(onClick = {
                        Toast.makeText(context, "Thêm ghi chú", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Default.Add, contentDescription = "Thêm ghi chú")
                    }
                }
                Lap4b3()
            }

            composable("student") {
                showBottomBar = false
                fabContent = null
                StudentProfileScreen()
            }
            composable("Lap5b1") {
                showBottomBar = true
                fabContent = null
                // Replace with your Lap5b1 composable
                 Lap5b1()
            }
            composable("lap5b2") {
                showBottomBar = true
                fabContent = null
                 Lap5b2()
            }
            composable("lap5b3") {
                showBottomBar = true
                fabContent = null
                 Lap5b3()
            }
        }
    }
}
