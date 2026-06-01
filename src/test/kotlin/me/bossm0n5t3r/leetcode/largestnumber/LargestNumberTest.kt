package me.bossm0n5t3r.leetcode.largestnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestNumberTest {
    private val sut = LargestNumber.Solution()

    private data class TestData(val nums: IntArray, val result: String) {
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
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(10, 2), "210"),
                TestData(intArrayOf(3, 30, 34, 5, 9), "9534330"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.largestNumber(testData.nums))
        }
    }
}
