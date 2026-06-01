package me.bossm0n5t3r.leetcode.moveZeroes

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MoveZeroesTest {
    private val moveZeroes = MoveZeroes.Solution()

    data class MoveZeroesTestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MoveZeroesTestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun moveZeroes() {
        val tests =
            listOf(
                MoveZeroesTestData(intArrayOf(0, 1, 0, 3, 12), intArrayOf(1, 3, 12, 0, 0)),
                MoveZeroesTestData(intArrayOf(0), intArrayOf(0)),
            )
        tests.forEach { test ->
            moveZeroes.moveZeroes(test.nums)
            assertTrue(test.nums.contentEquals(test.result))
        }
    }
}
