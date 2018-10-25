package com.cmgcode.dailies.pairlist

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PairListTest{

    @Test
    fun listContainsPairWithSum(){
        assertTrue(listOf(10, 15, 3, 7).containsPairWithSum(17))
        assertTrue(listOf(-10, 20, 5, 1).containsPairWithSum(-9))
        assertTrue(listOf(-10, 20, 5, 1).containsPairWithSum(10))
        assertFalse(listOf(10, 15, 3, 7).containsPairWithSum(0))
        assertFalse(emptyList<Int>().containsPairWithSum(5))
    }
}