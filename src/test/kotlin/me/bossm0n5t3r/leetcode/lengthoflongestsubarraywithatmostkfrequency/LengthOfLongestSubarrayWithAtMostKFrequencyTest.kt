package me.bossm0n5t3r.leetcode.lengthoflongestsubarraywithatmostkfrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLongestSubarrayWithAtMostKFrequencyTest {
    private val sut = LengthOfLongestSubarrayWithAtMostKFrequency.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Int) {
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
            result1 = 31 * result1 + result
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 1, 2, 3, 1, 2), 2, 6),
                TestData(intArrayOf(1, 2, 1, 2, 1, 2, 1, 2), 1, 2),
                TestData(intArrayOf(5, 5, 5, 5, 5, 5, 5), 4, 4),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxSubarrayLength(testData.nums, testData.k))
        }
    }
}
