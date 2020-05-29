package com.cmgcode.dailies

import org.junit.Test

class Workspace {

    @Test
    fun run() {
        var value = "Initial value"
        val test = Test(value)
        test.updateValue()
        println(value)
    }
}

class Test(var value: String){
    fun updateValue(){
        value = "new value"
    }
}
