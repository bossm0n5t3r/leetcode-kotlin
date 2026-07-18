package me.bossm0n5t3r.leetcode.findgreatestcommondivisorofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindGreatestCommonDivisorOfArrayTest {
    private val sut = FindGreatestCommonDivisorOfArray.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 5, 6, 9, 10), 2),
                TestData(intArrayOf(7, 5, 6, 8, 3), 1),
                TestData(intArrayOf(3, 3), 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findGCD(testData.nums))
        }
    }
}
