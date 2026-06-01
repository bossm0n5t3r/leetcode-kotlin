package me.bossm0n5t3r.leetcode.numberofwaystosplitarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToSplitArrayTest {
    private val sut = NumberOfWaysToSplitArray.Solution()

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
            listOf(TestData("[10,4,-8,7]".toIntArray(), 2), TestData("[2,3,1,0]".toIntArray(), 2))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.waysToSplitArray(testData.nums))
        }
    }
}
