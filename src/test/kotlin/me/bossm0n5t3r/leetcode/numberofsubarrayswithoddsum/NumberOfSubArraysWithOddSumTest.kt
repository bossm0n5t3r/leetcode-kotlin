package me.bossm0n5t3r.leetcode.numberofsubarrayswithoddsum

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubArraysWithOddSumTest {
    private val sut = NumberOfSubArraysWithOddSum.Solution()

    private data class TestData(val arr: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!arr.contentEquals(other.arr)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + arr.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,3,5]".toIntArray(), 4),
                TestData("[2,4,6]".toIntArray(), 0),
                TestData("[1,2,3,4,5,6,7]".toIntArray(), 16),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numOfSubarrays(testData.arr))
        }
    }
}
