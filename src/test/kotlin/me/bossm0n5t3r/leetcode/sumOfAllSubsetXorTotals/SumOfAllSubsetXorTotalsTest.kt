package me.bossm0n5t3r.leetcode.sumOfAllSubsetXorTotals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfAllSubsetXorTotalsTest {
    private val sut = SumOfAllSubsetXorTotals.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
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
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 3), 6),
                TestData(intArrayOf(5, 1, 6), 28),
                TestData(intArrayOf(3, 4, 5, 6, 7, 8), 480),
            )

        tests.forEach { test -> assertEquals(test.result, sut.subsetXORSum(test.nums)) }
    }
}
