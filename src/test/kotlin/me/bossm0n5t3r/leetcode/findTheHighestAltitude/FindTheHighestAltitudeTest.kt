package me.bossm0n5t3r.leetcode.findTheHighestAltitude

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheHighestAltitudeTest {
    private val sut = FindTheHighestAltitude.Solution()

    private data class TestData(val gain: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!gain.contentEquals(other.gain)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = gain.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(gain = intArrayOf(-5, 1, 5, 0, -7), result = 1),
                TestData(gain = intArrayOf(-4, -3, -2, -1, 4, 3, 2), result = 0),
            )

        tests.forEach { test -> assertEquals(sut.largestAltitude(test.gain), test.result) }
    }
}
