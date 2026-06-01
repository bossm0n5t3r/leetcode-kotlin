package me.bossm0n5t3r.leetcode.singleNumber

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SingleNumberTest {
    private val singleNumber = SingleNumber.Solution()

    data class SingleNumberTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SingleNumberTestData

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
    fun singleNumber() {
        val tests =
            listOf(
                SingleNumberTestData(intArrayOf(2, 2, 1), 1),
                SingleNumberTestData(intArrayOf(4, 1, 2, 1, 2), 4),
                SingleNumberTestData(intArrayOf(1), 1),
            )
        tests.forEach { test -> assertTrue(singleNumber.singleNumber(test.nums) == test.result) }
    }
}
