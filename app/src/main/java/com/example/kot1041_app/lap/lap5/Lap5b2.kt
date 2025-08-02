package com.example.kot1041_app.lap.lap5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kot1041_app.R

@Composable
fun Lap5b2() {
    var isLightOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val bulbImage = if (isLightOn) R.drawable.bongdenbat else R.drawable.bongdentat

        Image(
            painter = painterResource(id = bulbImage),
            contentDescription = if (isLightOn) "Đèn bật" else "Đèn tắt",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Switch để bật/tắt đèn
        Switch(
            checked = isLightOn,
            onCheckedChange = { isLightOn = it }
        )
    }
}
