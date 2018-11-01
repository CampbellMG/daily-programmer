package com.cmgcode.dailies.encodedmessage

import java.lang.StringBuilder

fun Int.getDecodeCount(): Int {
    val decodedValues = mutableListOf<String>()
    var operator = 1

    while(this % operator != this){
        operator *= 10
    }

    while(operator > 0){
        if(this % operator in 1..26 && this / operator in 1..26){
            val encoding = Encoding.mapping[this % operator]!!.toString() + Encoding.mapping[this / operator]!!.toString()
            decodedValues.add(encoding)
        }

        operator /= 10
    }

    val individualTranslation = StringBuilder()
    this.toString().forEach {
        if(it.toString().toInt() in 1..26){
            val decodedValue = Encoding.mapping[it.toString().toInt()]!!.toString()
            individualTranslation.append(decodedValue)
        }
    }

    if(individualTranslation.length == this.toString().length){
        decodedValues.add(individualTranslation.toString())
    }

    return decodedValues.distinct().size
}

object Encoding {
    val mapping = mapOf(
            1 to 'a',
            2 to 'b',
            3 to 'c',
            4 to 'd',
            5 to 'e',
            6 to 'f',
            7 to 'g',
            8 to 'h',
            9 to 'i',
            10 to 'j',
            11 to 'k',
            12 to 'l',
            13 to 'm',
            14 to 'n',
            15 to 'o',
            16 to 'p',
            17 to 'q',
            18 to 'r',
            19 to 's',
            20 to 't',
            21 to 'u',
            22 to 'v',
            23 to 'w',
            24 to 'x',
            25 to 'y',
            26 to 'z'
    )
}