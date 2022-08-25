package myFunctions

import kotlin.math.pow
import kotlin.math.round

fun roundPlus(value: Double, digits: Int = 0) =
    round(value * 10.toFloat().pow(digits)) / 10.toFloat().pow(digits)