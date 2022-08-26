import kotlin.random.Random

import myFunctions.roundPlus

const val NUM_OF_ROUNDS = 1_000_000
const val NUM_OF_DICE_FACES = 6
const val NUM_OF_DICE_VALUE_REPEAT = 1

const val DICE_VALUE_TO_COUNT = 1

var maxProbability = 0.0
var numOfDiceToMaxProbability = 0

fun main() {
    for (numOfDiceFaces in NUM_OF_DICE_VALUE_REPEAT..NUM_OF_DICE_FACES * NUM_OF_DICE_VALUE_REPEAT * 2)
        game(numOfDiceFaces)
    println("\nBest num of dices: $numOfDiceToMaxProbability, ${roundPlus(maxProbability * 100, 10)}%")
}

fun game(numOfDice: Int) {
    var numOfDiceValueToCount = 0
    var tempList: MutableList<Int>
    for (i in 0 until NUM_OF_ROUNDS) {
        tempList = mutableListOf()
        for (j in 0 until numOfDice)
            tempList.add(Random.nextInt(1, NUM_OF_DICE_FACES + 1))
        if (tempList.count { it == DICE_VALUE_TO_COUNT } == NUM_OF_DICE_VALUE_REPEAT)
            numOfDiceValueToCount++
    }
    val res = numOfDiceValueToCount.toDouble() / (NUM_OF_ROUNDS)
    println("Num of dices: $numOfDice: ${roundPlus(res * 100, 10)}%")
    if (res > maxProbability) {
        maxProbability = res
        numOfDiceToMaxProbability = numOfDice
    }
}