package me.bossm0n5t3r.leetcode.minimumoperationstomakearrayvaluesequaltok

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayValuesEqualToKTest {
    private val sut = MinimumOperationsToMakeArrayValuesEqualToK.Solution()

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
                TestData("[5,2,5,4,5]".toIntArray(), 2, 2),
                TestData("[2,1,2]".toIntArray(), 2, -1),
                TestData("[9,7,5,3]".toIntArray(), 1, 4),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minOperations(testData.nums, testData.k))
        }
    }
}
