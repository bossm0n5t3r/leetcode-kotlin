package me.bossm0n5t3r.leetcode.combinationSum4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CombinationSum4Test {
    private val sut = CombinationSum4.Solution()

    private data class Example(val nums: IntArray, val target: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Example

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun combinationSum4() {
        val tests = listOf(Example(intArrayOf(1, 2, 3), 4, 7), Example(intArrayOf(9), 3, 0))
        tests.forEach { test ->
            assertEquals(sut.combinationSum4(test.nums, test.target), test.result)
        }
    }
}
