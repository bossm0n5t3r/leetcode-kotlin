package me.bossm0n5t3r.leetcode.maximumproductofthreenumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfThreeNumbersTest {
    private val sut = MaximumProductOfThreeNumbers.Solution()

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
                TestData(intArrayOf(1, 2, 3), 6),
                TestData(intArrayOf(1, 2, 3, 4), 24),
                TestData(intArrayOf(-1, -2, -3), -6),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maximumProduct(testData.nums))
        }
    }
}
