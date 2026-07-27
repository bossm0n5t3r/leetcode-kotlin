package me.bossm0n5t3r.leetcode.maximumproductoftwoelementsinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoElementsInAnArrayTest {
    private val sut = MaximumProductOfTwoElementsInAnArray.Solution()

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
                TestData(intArrayOf(3, 4, 5, 2), 12),
                TestData(intArrayOf(1, 5, 4, 5), 16),
                TestData(intArrayOf(3, 7), 12),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxProduct(testData.nums))
        }
    }
}
