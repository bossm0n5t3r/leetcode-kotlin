package me.bossm0n5t3r.leetcode.minimumoperationstoexceedthresholdvalueii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToExceedThresholdValueIITest {
    private val sut = MinimumOperationsToExceedThresholdValueII.Solution()

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
                TestData("[2,11,10,1,3]".toIntArray(), 10, 2),
                TestData("[1,1,2,4,9]".toIntArray(), 20, 4),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minOperations(testData.nums, testData.k))
        }
    }
}
