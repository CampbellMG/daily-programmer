package com.cmgcode.dailies.pairlist

fun List<Int>.containsPairWithSum(targetSum: Int): Boolean{
    val sortedList = sorted()
    var lowIndex = 0
    var highIndex = sortedList.size - 1

    while(lowIndex < highIndex){
        val calculatedSum = sortedList[lowIndex] + sortedList[highIndex]
        when {
            calculatedSum < targetSum -> lowIndex++
            calculatedSum > targetSum -> highIndex--
            else -> return true
        }
    }

    return false
}