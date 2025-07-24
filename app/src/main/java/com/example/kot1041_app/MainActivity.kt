package com.example.kot1041_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kot1041_app.lap.lap4.Lap4b1
import com.example.kot1041_app.lap.lap4.Lap4b2
import com.example.kot1041_app.lap.lap4.Lap4b3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//          StudentProfileScreen()
//          Lap4b1()
//            Lap4b2()
            Lap4b3()
        }
            }
        }
@Preview
@Composable
fun xemThu (){
    gioiThieu("nguyen A", "KOTLIN")
}
//================================================
@Composable
fun gioiThieu(hoTen: String , lop : String){
    Text(
        text = """
           Thông tin SV
           Ho va ten: $hoTen
           Lop: $lop
       """.trimIndent(),
        fontSize = 30.sp,
        fontWeight = FontWeight.W900,
        color = Color.Red,
        modifier = Modifier.padding(20.dp)
            .border(3.dp,Color.Yellow,
                shape = RoundedCornerShape(10.dp)
            )
    )
}
@Composable
fun msgCard (noidung: String){
    Text(text =  noidung, fontSize = 20.sp, color = Color.Green)
}
@Composable
fun bodyScreen (){
    var chuoi by remember { mutableStateOf("") }
//    Column (...)  { ... } giống. trong react: <View ... >. ...children... </View>
    Column (
        modifier = Modifier.padding(20.dp).border(3.dp,Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // phan noi dung column
        Text(text = "Demo noi dung Column", fontSize = 40.sp)
        msgCard("Noi dung MSG 01")
        msgCard("Noi dung msg 02")
        msgCard("Chuoi trong state: $chuoi ")
        Button(
            onClick = { chuoi="AAAAAAAAAAAA" }
        ) {
            Text(text = "Hay bam nut")
        }
    }


}

