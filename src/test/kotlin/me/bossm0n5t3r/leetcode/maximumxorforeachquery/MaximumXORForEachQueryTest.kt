package me.bossm0n5t3r.leetcode.maximumxorforeachquery

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MaximumXORForEachQueryTest {
    private val sut = MaximumXORForEachQuery.Solution()

    private data class TestData(val nums: IntArray, val maximumBit: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (maximumBit != other.maximumBit) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + maximumBit
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[0,1,1,3]".toIntArray(), 2, "[0,3,2,3]".toIntArray()),
                TestData("[2,3,4,7]".toIntArray(), 3, "[5,2,6,5]".toIntArray()),
                TestData("[0,1,2,2,5,7]".toIntArray(), 3, "[4,3,6,4,6,7]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.getMaximumXor(testData.nums, testData.maximumBit))
            }
        }
    }
}
