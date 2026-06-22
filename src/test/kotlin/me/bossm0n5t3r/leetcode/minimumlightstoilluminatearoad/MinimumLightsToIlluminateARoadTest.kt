package me.bossm0n5t3r.leetcode.minimumlightstoilluminatearoad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumLightsToIlluminateARoadTest {
    private val sut = MinimumLightsToIlluminateARoad.Solution()

    private data class TestData(val lights: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!lights.contentEquals(other.lights)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + lights.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(0, 0, 0, 0), 2),
                TestData(intArrayOf(0, 0, 0, 2, 0), 1),
                TestData(intArrayOf(0, 0, 0), 1),
                TestData(intArrayOf(0, 0), 1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minLights(testData.lights))
        }
    }
}
