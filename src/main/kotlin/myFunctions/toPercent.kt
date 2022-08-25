package myFunctions

fun toPercent(num: Double, total: Int, roundDigits: Int = 2) =
    "${roundPlus((num / total) * 100, roundDigits)}%"