package me.bossm0n5t3r.leetcode.missingNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MissingNumberTest {
    private val missingNumber = MissingNumber.Solution()

    data class MissingNumberTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MissingNumberTestData

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
    fun missingNumber() {
        val tests =
            listOf(
                MissingNumberTestData(intArrayOf(3, 0, 1), 2),
                MissingNumberTestData(intArrayOf(0, 1), 2),
                MissingNumberTestData(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1), 8),
                MissingNumberTestData(intArrayOf(0), 1),
            )
        tests.forEach { test -> assertEquals(test.result, missingNumber.missingNumber(test.nums)) }
    }
}
