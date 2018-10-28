package com.cmgcode.dailies.positiveint

import org.junit.Test
import kotlin.test.assertEquals

class PositiveIntTest {

    @Test
    fun emptyArrayProducesOne(){
        assertEquals(1, mutableListOf<Int>().findSmallestMissingPositive())
    }

    @Test
    fun negativeArrayProducesOne(){
        assertEquals(1, mutableListOf(-1, -2, -3 ,-4).findSmallestMissingPositive())
    }

    @Test
    fun minValueCorrect(){
        assertEquals(2, mutableListOf(3, 4, -1, 1).findSmallestMissingPositive())
        assertEquals(3, mutableListOf(1, 2, 0).findSmallestMissingPositive())
    }

    @Test(timeout = 2000)
    fun handlesLargeList(){
        assertEquals(1500001, (0..1500000).toMutableList().findSmallestMissingPositive())
    }
}


