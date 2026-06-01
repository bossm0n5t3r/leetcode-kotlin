package me.bossm0n5t3r.leetcode.partitionequalsubsetsum

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionEqualSubsetSumTest {
    private val sut = PartitionEqualSubsetSum.Solution()

    private data class TestData(val nums: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,5,11,5]".toIntArray(), true),
                TestData("[1,2,3,5]".toIntArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canPartition(testData.nums))
        }
    }
}
