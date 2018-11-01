package com.cmgcode.dailies.encodedmessage

import org.junit.Assert.*
import org.junit.Test

class MessageDecoderTest {

    @Test
    fun decodeQuantityCorrect(){
        assertEquals(3, 111.getDecodeCount())
        assertEquals(2, 153.getDecodeCount())
    }
}
