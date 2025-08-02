package com.example.kot1041_app.model

// com.example.kot1041_app.navigate.BottomNavItem.kt

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem("Bài 1", Icons.Default.Home, "lap4b1"),
    BottomNavItem("Bài 2", Icons.Default.Favorite, "lap4b2"),
    BottomNavItem("Bài 3", Icons.Default.List, "lap4b3"),
    BottomNavItem("Student", Icons.Default.Person, "student"),
    BottomNavItem("Bài 5.1", Icons.Default.Add, "lap5b1"),
    BottomNavItem("Bài 5.2", Icons.Default.AddCircle, "lap5b2"),
    BottomNavItem("Bài 5.3", Icons.Default.CheckCircle, "lap5b3")

)
