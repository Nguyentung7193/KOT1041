package com.example.kot1041_app.lap.lap1

fun main() {
    print("Nguyen Xuan Tung - PH63287\n")
    print("==========================\n")
    println("Quanh năm buôn bán ở non sông")
    println("Nuôi đủ năm con với một chồng")
    println("\t Lặn lội thân cờ khi quãng vắng")
    println("\t teo sèo mặt nước buổi đò đồng")
    println("Một duyên 2 nợ âu đành phận")
    println("Năm nắng mười mưa há chẳng công")
    println("\t cha mẹ thói đời \"ăn ở bạc\"")
    println("\t có chồng hờ hững cũng như không")
}
fun main2() {
fun calculateOperations() {
    print("Enter number a: ")
    val a = readLine()?.toDoubleOrNull() ?: return println("Invalid input for a")
    print("Enter number b: ")
    val b = readLine()?.toDoubleOrNull() ?: return println("Invalid input for b")

    println("Sum: ${a + b}")
    println("Difference: ${a - b}")
    println("Product: ${a * b}")
    if (b != 0.0) {
        println("Quotient: ${a / b}")
    } else {
        println("Cannot divide by zero")
    }
}
}