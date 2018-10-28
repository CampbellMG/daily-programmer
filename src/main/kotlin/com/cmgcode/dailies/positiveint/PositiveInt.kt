package com.cmgcode.dailies.positiveint

fun MutableList<Int>.findSmallestMissingPositive(): Int {
    val distinctValues = distinct()
            .filter { it > 0 }
            .toSortedSet()
    var index = 1

    while(distinctValues.isNotEmpty() && distinctValues.first() == index){
        distinctValues.remove(distinctValues.first())
        index++
    }

    return index
}