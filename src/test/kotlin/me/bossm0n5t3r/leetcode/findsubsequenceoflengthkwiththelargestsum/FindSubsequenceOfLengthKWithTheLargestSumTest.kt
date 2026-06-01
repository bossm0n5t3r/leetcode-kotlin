package me.bossm0n5t3r.leetcode.findsubsequenceoflengthkwiththelargestsum

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindSubsequenceOfLengthKWithTheLargestSumTest {
    private val sut = FindSubsequenceOfLengthKWithTheLargestSum.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[2,1,3,3]".toIntArray(), 2, "[3,3]".toIntArray()),
                TestData("[-1,-2,3,4]".toIntArray(), 3, "[-1,3,4]".toIntArray()),
                TestData("[3,4,3,3]".toIntArray(), 2, "[3,4]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.maxSubsequence(testData.nums, testData.k))
            }
        }
    }
}
