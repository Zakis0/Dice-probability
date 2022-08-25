import kotlin.random.Random

import myFunctions.roundPlus

const val NUM_OF_DICE_FACES = 6
const val NUM_OF_ROUNDS = 1_000_000_000

const val DICE_VALUE_TO_COUNT = 1

var max = 0.0
var nMax = 0

fun main() {
    for (numOfDiceFaces in 1..NUM_OF_DICE_FACES * 2)
        game(numOfDiceFaces)
    println("\nN: $nMax, ${roundPlus(max * 100, 10)}%")
}

fun game(numOfDice: Int) {
    val stats = Array(numOfDice + 1, {0})
    var tempList: MutableList<Int>
    for (i in 0 until NUM_OF_ROUNDS) {
        tempList = mutableListOf()
        for (j in 0 until numOfDice)
            tempList.add(Random.nextInt(1, NUM_OF_DICE_FACES + 1))
        stats[tempList.count({it == DICE_VALUE_TO_COUNT})] += 1
    }
//    for (k in stats.indices)
//        println("$k: ${toPercent(stats[k].toFloat(), NUM_OF_ROUNDS)}")
    val res = stats[1].toDouble() / (NUM_OF_ROUNDS)
    println("$numOfDice: ${roundPlus(res * 100, 10)}%")
    if (res > max) {
        max = res
        nMax = numOfDice
    }
}