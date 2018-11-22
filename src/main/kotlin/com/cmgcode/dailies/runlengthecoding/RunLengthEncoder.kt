package com.cmgcode.dailies.runlengthecoding

fun String.runLengthEncode(): String{
    var count = 1
    var encodedString = ""

    for(i in 1..length){
        if(i != length && get(i) == get(i - 1)){
            count++
        }else{
            encodedString += "$count${get(i-1)}"
            count = 1
        }
    }

    return encodedString
}