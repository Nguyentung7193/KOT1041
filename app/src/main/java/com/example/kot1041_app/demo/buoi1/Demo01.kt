package com.example.kot1041_app.demo.buoi1

// khai bao hang
const val HO_TEN = "Nguyen Xuan Tung"

fun main () {
    print("Xin chào:")
    println("Nguyen Xuan Tung")
    println("dm")

    var a: Int = 2
    a = 5
    val b: Int = 3
//    b = 2
    var c = 4
//    c = "Nguyen Xuan Tung"
    println("a= $a, b = $b, c = $c\n")
    println("Họ tên: $HO_TEN")
    println("Họ tên: ${HO_TEN.uppercase() + " dcm "}")
}
