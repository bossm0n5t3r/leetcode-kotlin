package me.bossm0n5t3r.leetcode.maximumascendingsubarraysum

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAscendingSubarraySumTest {
    private val sut = MaximumAscendingSubarraySum.Solution()

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
                TestData("[10,20,30,5,10,50]".toIntArray(), 65),
                TestData("[10,20,30,40,50]".toIntArray(), 150),
                TestData("[12,17,15,13,10,11,12]".toIntArray(), 33),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxAscendingSum(testData.nums))
        }
    }
}
