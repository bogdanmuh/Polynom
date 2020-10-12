package ru.smak

import ru.smak.polynoms.Polynom
import ru.smak.polynoms.Newton

fun main()
{
    val p1 = Polynom(doubleArrayOf(1.0, 0.0, 3.0, 0.0, 0.0))
    val p2 = Polynom(doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0))
    val p3 = Polynom(doubleArrayOf(0.0, 0.0, -3.0, 0.0, -1.0))
    val p4 = Polynom(doubleArrayOf(7.0, 0.0, 3.0, 0.0, 0.0))
    val p5 = Polynom(doubleArrayOf(-1.0, 0.0, 0.0, 0.0, 0.0))
    val p6 = Polynom(doubleArrayOf(1.0, 0.0, 0.0, 0.0, 0.0))
    println(p1)
    println(p3)
    println(p1+p3)
    println(p1(2.0))
    val n1 = Newton(mutableMapOf(
            -3.0 to -1.0,
            0.0 to 1.0,
            1.0 to -1.0
    ))
    println(n1)
}