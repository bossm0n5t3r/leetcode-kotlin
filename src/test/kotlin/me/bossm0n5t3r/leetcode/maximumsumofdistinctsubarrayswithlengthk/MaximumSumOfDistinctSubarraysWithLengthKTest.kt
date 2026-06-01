package me.bossm0n5t3r.leetcode.maximumsumofdistinctsubarrayswithlengthk

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSumOfDistinctSubarraysWithLengthKTest {
    private val sut = MaximumSumOfDistinctSubarraysWithLengthK.Solution()

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
            listOf(
                TestData("[1,5,4,2,9,9,9]".toIntArray(), 3, 15),
                TestData("[4,4,4]".toIntArray(), 3, 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maximumSubarraySum(testData.nums, testData.k))
        }
    }
}
