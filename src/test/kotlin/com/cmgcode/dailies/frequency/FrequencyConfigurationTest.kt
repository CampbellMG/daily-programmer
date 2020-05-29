package com.cmgcode.dailies.frequency

import org.junit.Test

class FrequencyConfigurationTest {
    @Test fun runWithExpectRange(){
       FrequencyConfiguration(.02, true).calculateForTargetRange((8..15))
    }
}
// --------------------------------------------------------
//
// Target: 8 Hz (0.125 s)
//
// Floor value: 8.333333333333334 Hz (12 * 0.01 s = 0.12 s)
//
// Ceiling value: 7.692307692307692 Hz (13 * 0.01 s = 0.13 s)
//
// Closest: 7.692307692307692 Hz (0.13 s)
//
// --------------------------------------------------------
//
// Target: 9 Hz (0.1111111111111111 s)
//
// Floor value: 9.090909090909092 Hz (11 * 0.01 s = 0.11 s)
//
// Ceiling value: 8.333333333333334 Hz (12 * 0.01 s = 0.12 s)
//
// Closest: 9.090909090909092 Hz (0.11 s)
//
// --------------------------------------------------------
//
// Target: 10 Hz (0.1 s)
//
// Floor value: 10.0 Hz (10 * 0.01 s = 0.1 s)
//
// Ceiling value: 10.0 Hz (10 * 0.01 s = 0.1 s)
//
// Closest: 10.0 Hz (0.1 s)
//
// --------------------------------------------------------
//
// Target: 11 Hz (0.09090909090909091 s)
//
// Floor value: 11.11111111111111 Hz (9 * 0.01 s = 0.09 s)
//
// Ceiling value: 10.0 Hz (10 * 0.01 s = 0.1 s)
//
// Closest: 11.11111111111111 Hz (0.09 s)
//
// --------------------------------------------------------
//
// Target: 12 Hz (0.08333333333333333 s)
//
// Floor value: 12.5 Hz (8 * 0.01 s = 0.08 s)
//
// Ceiling value: 11.11111111111111 Hz (9 * 0.01 s = 0.09 s)
//
// Closest: 12.5 Hz (0.08 s)
//
// --------------------------------------------------------
//
// Target: 13 Hz (0.07692307692307693 s)
//
// Floor value: 14.285714285714285 Hz (7 * 0.01 s = 0.07 s)
//
// Ceiling value: 12.5 Hz (8 * 0.01 s = 0.08 s)
//
// Closest: 12.5 Hz (0.08 s)
//
// --------------------------------------------------------
//
// Target: 14 Hz (0.07142857142857142 s)
//
// Floor value: 14.285714285714285 Hz (7 * 0.01 s = 0.07 s)
//
// Ceiling value: 12.5 Hz (8 * 0.01 s = 0.08 s)
//
// Closest: 14.285714285714285 Hz (0.07 s)
//
// --------------------------------------------------------
//
// Target: 15 Hz (0.06666666666666667 s)
//
// Floor value: 16.666666666666668 Hz (6 * 0.01 s = 0.06 s)
//
// Ceiling value: 14.285714285714285 Hz (7 * 0.01 s = 0.07 s)
//
// Closest: 14.285714285714285 Hz (0.07 s)
//
// --------------------------------------------------------