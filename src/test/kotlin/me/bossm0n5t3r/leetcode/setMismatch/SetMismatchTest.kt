package me.bossm0n5t3r.leetcode.setMismatch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SetMismatchTest {
    private val sut = SetMismatch.Solution()

    private data class TestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

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
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 2, 4), intArrayOf(2, 3)),
                TestData(intArrayOf(1, 1), intArrayOf(1, 2)),
            )

        tests.forEach { test ->
            assertThat(sut.findErrorNums(test.nums)).containsExactly(test.result.toTypedArray())
        }
    }
}
