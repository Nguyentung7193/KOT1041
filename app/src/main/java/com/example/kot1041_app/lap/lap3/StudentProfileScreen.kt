package com.example.kot1041_app.lap.lap3

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot1041_app.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf



@Composable
fun StudentProfileScreen() {
    val openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val phoneNumber = "0395257193"
    val email = "nguyentung260310@gmail.com"
    val name = "Nguyễn Xuân Tùng"
    val interests =
        "Tùng đẹp trai 10 người yêu,Tùng đẹp trai 10 người yêu,Tùng đẹp trai 10 người yêu,Tùng đẹp trai 10 người yêu,Tùng đẹp trai 10 người yêu,Tùng đẹp trai 10 người yêu,Tùng đẹp trai 10 người yêu"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Thông tin sinh viên",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.raiden),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)

        )

        Spacer(modifier = Modifier.height(16.dp))

        StyledName(name = name)
//        Text(
//            text = "Nguyen Xuan Tung",
//            style = TextStyle(
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold
//            ),
////            modifier = Modifier
////                .fillMaxWidth()
////                .wrapContentWidth(Alignment.CenterHorizontally)
////            modifier = Modifier.fillMaxWidth()
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "📞 $phoneNumber",
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    val clipboard =
                        context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Phone Number", phoneNumber)
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(context, "Đã copy số điện thoại!", Toast.LENGTH_SHORT).show()
                }
            )

            Text(text = "✉️ $email", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = interests,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 16.sp, fontStyle = FontStyle.Italic)
        )

        Spacer(modifier = Modifier.height(16.dp))

//        Button(
//            onClick = {
//                Toast.makeText(context, interests, Toast.LENGTH_LONG).show()
//                Toast.makeText(context, phoneNumber, Toast.LENGTH_LONG).show()
//                Toast.makeText(context, email, Toast.LENGTH_LONG).show()
//                Toast.makeText(context, name, Toast.LENGTH_LONG).show()
//            },
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        ) {
//            Icon(Icons.Filled.Info, contentDescription = "Chi tiết")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text("Chi tiết")
//        }
        Button(
            onClick = {
                openDialog.value = true
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(Icons.Filled.Info, contentDescription = "Chi tiết")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Chi tiết")
        }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text("Sở thích") },
                text = {
                    Text(
                        text = interests,
                        style = TextStyle(fontSize = 16.sp)
                    )
                },
                confirmButton = {
                    TextButton(onClick = { openDialog.value = false }) {
                        Text("Đóng")
                    }
                }
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Mã SV", fontWeight = FontWeight.Bold)
                Text("PH63287")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Lớp", fontWeight = FontWeight.Bold)
                Text("KotLin")
            }
        }
    }
}
@Composable
fun StyledName(name: String) {
    val styledText = buildAnnotatedString {
        name.split(" ").forEach { word ->
            if (word.isNotEmpty()) {
                withStyle(style = SpanStyle(color = Color.Red)) {
                    append(word.first())
                }
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append(word.drop(1) + " ")
                }
            }
        }
    }

    Text(
        text = styledText,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
