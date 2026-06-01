package me.bossm0n5t3r.leetcode.smallestmissingintegergreaterthansequentialprefixsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestMissingIntegerGreaterThanSequentialPrefixSumTest {
    private val sut = SmallestMissingIntegerGreaterThanSequentialPrefixSum.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 2, 5), 6),
                TestData(intArrayOf(3, 4, 5, 1, 12, 14, 13), 15),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.missingInteger(testData.nums))
        }
    }
}
