package com.cmgcode.dailies.frequency

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor

data class FrequencyConfiguration(val deltaTime: Double, val showCalculation: Boolean = false) {
    fun calculateForTargetRange(frequencyRange: IntRange) {
        frequencyRange.forEach {
            val requiredDelta = (1.0 / it)

            val floor = floor(requiredDelta / deltaTime).toInt()
            val ceil = ceil(requiredDelta / deltaTime).toInt()

            val floorDelta = floor * deltaTime
            val ceilDelta = ceil * deltaTime

            val floorFrequency = 1 / floorDelta
            val ceilFrequency = 1 / ceilDelta

            val closestFrequencyToDelta = if (abs(it - floorFrequency) < abs(it - ceilFrequency)) {
                floorFrequency to floorDelta
            } else {
                ceilFrequency to ceilDelta
            }

            println("--------------------------------------------------------")
            println("Target: $it Hz ($requiredDelta s)")

            if (showCalculation) {
                println("Floor value: $floorFrequency Hz ($floor * $deltaTime s = $floorDelta s)")
                println("Ceiling value: $ceilFrequency Hz ($ceil * $deltaTime s = $ceilDelta s)")
            }

            println("Closest: ${closestFrequencyToDelta.first} Hz (${closestFrequencyToDelta.second} s)")
        }
    }

    fun Double.round(decimals: Int = 2): Double = "%.${decimals}f"
            .format(this)
            .toDouble()
}
