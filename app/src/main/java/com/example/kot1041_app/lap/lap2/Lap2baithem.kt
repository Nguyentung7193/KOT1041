package com.example.kot1041_app.lap.lap2

fun main() {
    print("Nhập tên: ")
    val name = readLine()?.trim() ?: ""
    print("Nhập tuổi: ")
    val age = readLine()?.toIntOrNull() ?: 0
    print("Nhập giới tính (0 là nam, 1 là nữ): ")
    val gender = readLine()?.toIntOrNull() ?: -1

    val upperName = name.uppercase()

    val genderStr = when (gender) {
        0 -> "Nam"
        1 -> "Nữ"
        else -> "LGBT"
    }

    val ageGroup = when (age) {
        in 0 until 18 -> "Trẻ em"
        in 18 until 40 -> "Thanh niên"
        in 40 until 60 -> "Trung niên"
        else -> if (age >= 60) "Người già" else "Không xác định"
    }

    println("Họ tên: $upperName")
    println("Tuổi: $age")
    println("Giới tính: $genderStr")
    println("Nhóm tuổi: $ageGroup")
    println("Mã SV: Ph63287")
}