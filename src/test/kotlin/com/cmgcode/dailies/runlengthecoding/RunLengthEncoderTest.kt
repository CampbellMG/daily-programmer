package com.cmgcode.dailies.runlengthecoding

import org.junit.Assert.*
import org.junit.Test

class RunLengthEncoderTest {

    @Test
    fun encodeEmptyString_ReturnsEmptyString(){
        assertEquals("", "".runLengthEncode())
    }

    @Test
    fun encodeRecurrentString_ReturnsEncodedString() {
        assertEquals("4A3B2C1D2A", "AAAABBBCCDAA".runLengthEncode())
    }
}