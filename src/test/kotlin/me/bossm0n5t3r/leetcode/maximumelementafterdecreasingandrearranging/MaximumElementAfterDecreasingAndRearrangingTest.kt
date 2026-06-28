package me.bossm0n5t3r.leetcode.maximumelementafterdecreasingandrearranging

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumElementAfterDecreasingAndRearrangingTest {
    private val sut = MaximumElementAfterDecreasingAndRearranging.Solution()

    private data class TestData(val arr: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!arr.contentEquals(other.arr)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + arr.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 2, 1, 2, 1), 2),
                TestData(intArrayOf(100, 1, 1000), 3),
                TestData(intArrayOf(1, 2, 3, 4, 5), 5),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maximumElementAfterDecrementingAndRearranging(testData.arr),
            )
        }
    }
}
