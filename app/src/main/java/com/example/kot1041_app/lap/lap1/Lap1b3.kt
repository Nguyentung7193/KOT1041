package com.example.kot1041_app.lap.lap1

fun main() {
    var a = 0.0
    var b = 0.0
    print("Nhập số a: ")
    var s = readLine()
    if (s != null) a = s.toDouble()
    print("Nhập số b: ")
    s = readLine()
    if (s != null) b = s.toDouble()
    println("Tổng: ${a.plus(b)}")
    println("Hiệu: ${a.minus(b)}")
    println("Tích: ${a.times(b)}")
    println("Thương: ${a.div(b)}")
    println("Tổng: ${a + b}")
    println("Hiệu: ${a - b}")
    println("Tích: ${a * b}")
    println("Thương: ${a / b}")
}