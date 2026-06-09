package me.bossm0n5t3r.leetcode.maximumtotalsubarrayvaluei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSubarrayValueITest {
    private val sut = MaximumTotalSubarrayValueI.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(intArrayOf(1, 3, 2), 2, 4), TestData(intArrayOf(4, 2, 5, 1), 3, 12))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxTotalValue(testData.nums, testData.k))
        }
    }
}
