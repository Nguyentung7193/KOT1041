package com.example.kot1041_app.lap.lap5

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun Lap5b3() {
    val context = LocalContext.current
    val genres = listOf(
        "Mondstatd", "Liyue", "Inazuma", "sumeru",
        "fontainr", "Natlan"
    )
    val suggestions = listOf("nuivilet", "furina", "RaidenShogun", "Navia", "Lumin")

    var selectedGenres by remember { mutableStateOf(setOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AssistChip(
                onClick = {},
                label = { Text("Chọn thể loại yêu thích của bạn") }
            )

            if (selectedGenres.isNotEmpty()) {
                AssistChip(
                    onClick = { selectedGenres = emptySet() },
                    label = { Text("Xoá") },
//                    modifier = Modifier.border(
//                        width = 1.dp,
//                        color = Color.Red,
////                        shape = RoundedCornerShape(20.dp)
//                    ),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color.Red,
                        labelColor = Color.White
                    )

                )
            }
        }

        Text("Thể loại:", style = MaterialTheme.typography.titleMedium)
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            genres.forEach { genre ->
                FilterChip(
                    selected = selectedGenres.contains(genre),
                    onClick = {
                        selectedGenres = if (selectedGenres.contains(genre)) {
                            selectedGenres - genre
                        } else {
                            selectedGenres + genre
                        }
                    },
                    label = { Text(genre) }
                )
            }
        }

        Text("Gợi ý thêm:", style = MaterialTheme.typography.titleMedium)
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            suggestions.forEach { suggestion ->
                SuggestionChip(
                    onClick = {
                        selectedGenres = selectedGenres + suggestion
                    },
                    label = { Text(suggestion) }
                )
            }
        }

        if (selectedGenres.isNotEmpty()) {
            Text("Đã chọn:", style = MaterialTheme.typography.titleMedium)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                selectedGenres.forEach { genre ->
                    InputChip(
                        selected = true,
                        onClick = {  Toast.makeText(context, "Đây là $genre", Toast.LENGTH_SHORT).show() },
                        label = { Text(genre) },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Bỏ chọn",
                                modifier = Modifier.clickable {
                                    selectedGenres = selectedGenres - genre
                                    Toast.makeText(context, "Đã xoá \"$genre\"", Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    )
                }
            }
        }
    }
}
