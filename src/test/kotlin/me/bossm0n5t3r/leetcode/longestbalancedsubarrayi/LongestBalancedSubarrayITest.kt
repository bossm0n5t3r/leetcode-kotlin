package me.bossm0n5t3r.leetcode.longestbalancedsubarrayi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubarrayITest {
    private val sut = LongestBalancedSubarrayI.Solution()

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
                TestData("[2,5,4,3]".toIntArray(), 4),
                TestData("[3,2,2,5,4]".toIntArray(), 5),
                TestData("[1,2,3,2]".toIntArray(), 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.longestBalanced(testData.nums))
        }
    }
}
