package me.bossm0n5t3r.leetcode.divideanarrayintosubarrayswithminimumcostii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideAnArrayIntoSubarraysWithMinimumCostIITest {
    private val sut = DivideAnArrayIntoSubarraysWithMinimumCostII.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val dist: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (dist != other.dist) return false
            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + dist
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,3,2,6,4,2]".toIntArray(), 3, 3, 5),
                TestData("[10,1,2,2,2,1]".toIntArray(), 4, 3, 15),
                TestData("[10,8,18,9]".toIntArray(), 3, 1, 36),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumCost(testData.nums, testData.k, testData.dist))
        }
    }
}
