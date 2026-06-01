package me.bossm0n5t3r.leetcode.makesumdivisiblebyp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MakeSumDivisibleByPTest {
    private val sut = MakeSumDivisibleByP.Solution()

    private data class TestData(val nums: IntArray, val p: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (p != other.p) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + p
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(3, 1, 4, 2), 6, 1),
                TestData(intArrayOf(6, 3, 5, 2), 9, 2),
                TestData(intArrayOf(1, 2, 3), 3, 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minSubarray(testData.nums, testData.p))
        }
    }
}
