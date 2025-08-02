package com.example.kot1041_app.lap.lap6

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


enum class SeatStatus {
    AVAILABLE,
    SELECTED_PRESET,    // Ghế đã được chọn từ trước (không thể bỏ chọn)
    SELECTED_USER,      // Ghế người dùng mới chọn (có thể bỏ chọn)
    BOOKED,
    AISLE
}

data class Seat(
    val id: String,
    var status: SeatStatus
)

@Composable
fun Lap6b3(seats: List<Seat>, totalSeatsPerRow: Int) {
    val seatList = remember { seats.toMutableStateList() }
    var showSnackbar by remember { mutableStateOf(false) }
    var snackbarMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text("MÀN CHIẾU", style = MaterialTheme.typography.titleMedium)
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(totalSeatsPerRow),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(seatList) { seat ->
                    if (seat.status == SeatStatus.AISLE) {
                        Spacer(modifier = Modifier.size(32.dp))
                    } else {
                        SeatItem(seat) {
                            // Tìm index của ghế trong danh sách và cập nhật trạng thái
                            val index = seatList.indexOf(seat)
                            if (index != -1) {
                                val currentSeat = seatList[index]
                                when (currentSeat.status) {
                                    SeatStatus.AVAILABLE -> {
                                        // Ghế trống -> chọn bởi người dùng
                                        seatList[index] = currentSeat.copy(status = SeatStatus.SELECTED_USER)
                                        snackbarMessage = "Đã chọn ghế ${currentSeat.id}"
                                        showSnackbar = true
                                    }
                                    SeatStatus.SELECTED_USER -> {
                                        // Ghế được chọn bởi người dùng -> có thể bỏ chọn
                                        seatList[index] = currentSeat.copy(status = SeatStatus.AVAILABLE)
                                        snackbarMessage = "Đã bỏ chọn ghế ${currentSeat.id}"
                                        showSnackbar = true
                                    }
                                    SeatStatus.SELECTED_PRESET -> {
                                        // Ghế đã được chọn từ trước -> không thể bỏ chọn
                                        snackbarMessage = "Ghế ${currentSeat.id} đã được chọn trước đó"
                                        showSnackbar = true
                                    }
                                    SeatStatus.BOOKED -> {
                                        // Ghế đã đặt -> không thể chọn
                                        snackbarMessage = "Ghế ${currentSeat.id} đã có người đặt"
                                        showSnackbar = true
                                    }
                                    else -> {
                                        // Lối đi hoặc trạng thái khác
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Snackbar đơn giản
        if (showSnackbar) {
            LaunchedEffect(showSnackbar) {
                kotlinx.coroutines.delay(2000)
                showSnackbar = false
            }

            Card(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Black.copy(alpha = 0.8f)
                )
            ) {
                Text(
                    text = snackbarMessage,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun SeatItem(seat: Seat, onClick: () -> Unit) {
    val seatColor = when (seat.status) {
        SeatStatus.AVAILABLE -> Color.Gray.copy(alpha = 0.5f)
        SeatStatus.SELECTED_PRESET -> Color(0xFFFF5722)    // Màu đỏ cam cho ghế đã chọn từ trước
        SeatStatus.SELECTED_USER -> Color(0xFFFF9800)      // Màu cam cho ghế người dùng chọn
        SeatStatus.BOOKED -> Color.DarkGray
        else -> Color.Transparent
    }

    val isClickable = when (seat.status) {
        SeatStatus.AVAILABLE, SeatStatus.SELECTED_USER, SeatStatus.SELECTED_PRESET, SeatStatus.BOOKED -> true
        else -> false
    }

    Box(
        modifier = Modifier
            .size(40.dp)
            .background(seatColor, shape = RoundedCornerShape(4.dp))
            .clickable(enabled = isClickable) {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = seat.id,
            style = MaterialTheme.typography.labelSmall,
            color = Color.White
        )
    }
}

fun createTheaterSeating(
    totalRows: Int,
    totalSeatsPerRow: Int,
    aislePositionInRow: Int,
    aislePositionInColumn: Int
): List<Seat> {
    val seats = mutableListOf<Seat>()
    for (row in 0 until totalRows) {
        for (col in 0 until totalSeatsPerRow) {
            val status = when {
                col == aislePositionInRow || row == aislePositionInColumn -> SeatStatus.AISLE
                else -> {
                    val randomValue = Random.nextFloat()
                    when {
                        randomValue < 0.1f -> SeatStatus.SELECTED_PRESET // 10% ghế đã chọn từ trước
                        randomValue < 0.3f -> SeatStatus.BOOKED          // 20% booked (0.1-0.3)
                        else -> SeatStatus.AVAILABLE                     // 70% available
                    }
                }
            }
            seats.add(Seat(id = "${row + 1}${'A' + col}", status = status))
        }
    }
    return seats
}

@Preview(showBackground = true)
@Composable
fun PreviewSeatStates() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        SeatItem(seat = Seat("A1", SeatStatus.AVAILABLE)) {}
        SeatItem(seat = Seat("A2", SeatStatus.SELECTED_PRESET)) {}
        SeatItem(seat = Seat("A3", SeatStatus.SELECTED_USER)) {}
        SeatItem(seat = Seat("A4", SeatStatus.BOOKED)) {}
        SeatItem(seat = Seat("A5", SeatStatus.AISLE)) {}
    }
}