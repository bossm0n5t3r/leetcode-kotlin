package me.bossm0n5t3r.leetcode.countnumberofmaximumbitwiseorsubsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfMaximumBitwiseORSubsetsTest {
    private val sut = CountNumberOfMaximumBitwiseORSubsets.Solution()

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
                TestData(intArrayOf(3, 1), 2),
                TestData(intArrayOf(2, 2, 2), 7),
                TestData(intArrayOf(3, 2, 1, 5), 6),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countMaxOrSubsets(testData.nums))
        }
    }
}
