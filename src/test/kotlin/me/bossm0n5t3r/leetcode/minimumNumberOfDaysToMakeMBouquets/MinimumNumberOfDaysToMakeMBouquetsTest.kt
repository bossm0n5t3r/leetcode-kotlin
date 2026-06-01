package me.bossm0n5t3r.leetcode.minimumNumberOfDaysToMakeMBouquets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfDaysToMakeMBouquetsTest {
    private val sut = MinimumNumberOfDaysToMakeMBouquets.Solution()

    private data class TestData(val bloomDay: IntArray, val m: Int, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!bloomDay.contentEquals(other.bloomDay)) return false
            if (m != other.m) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = bloomDay.contentHashCode()
            result1 = 31 * result1 + m
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 10, 3, 10, 2), 3, 1, 3),
                TestData(intArrayOf(1, 10, 3, 10, 2), 3, 2, -1),
                TestData(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3, 12),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.minDays(test.bloomDay, test.m, test.k))
        }
    }
}
