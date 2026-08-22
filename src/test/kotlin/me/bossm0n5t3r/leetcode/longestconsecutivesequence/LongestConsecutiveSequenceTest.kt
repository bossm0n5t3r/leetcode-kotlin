package me.bossm0n5t3r.leetcode.longestconsecutivesequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {
    private val sut = LongestConsecutiveSequence.Solution()

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
                TestData(intArrayOf(100, 4, 200, 1, 3, 2), 4),
                TestData(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9),
                TestData(intArrayOf(1, 0, 1, 2), 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.longestConsecutive(testData.nums))
        }
    }
}
