package com.example.kot1041_app.lap.lap4

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kot1041_app.lap.lap4.component.NoteItem

@Composable
fun Lap4b3() {
    val context = LocalContext.current
    val notes = listOf(
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn",
        "Chủ nhật này chấm ASM cả 2 môn"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(notes) { note ->
            NoteItem(title = note)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}


