package me.bossm0n5t3r.leetcode.findthenumberofsubsequenceswithequalgcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfSubsequencesWithEqualGCDTest {
    private val sut = FindTheNumberOfSubsequencesWithEqualGCD.Solution()

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
                TestData(intArrayOf(1, 2, 3, 4), 10),
                TestData(intArrayOf(10, 20, 30), 2),
                TestData(intArrayOf(1, 1, 1, 1), 50),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.subsequencePairCount(testData.nums))
        }
    }
}
