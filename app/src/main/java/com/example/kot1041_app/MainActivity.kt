package com.example.kot1041_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.kot1041_app.navigate.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//          StudentProfileScreen()
//          Lap4b1()
//          Lap4b2()
//          Lap4b3()
            AppNavigation()
        }
            }
        }

