package me.bossm0n5t3r.leetcode.jumpGame2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class JumpGame2Test {
    private val sut = JumpGame2.Solution()

    private data class Example(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Example

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
    fun jump() {
        val tests =
            listOf(Example(intArrayOf(2, 3, 1, 1, 4), 2), Example(intArrayOf(2, 3, 0, 1, 4), 2))
        tests.forEach { test -> assertEquals(sut.jump(test.nums), test.result) }
    }
}
