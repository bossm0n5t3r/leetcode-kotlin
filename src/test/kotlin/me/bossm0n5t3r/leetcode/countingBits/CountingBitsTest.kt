package me.bossm0n5t3r.leetcode.countingBits

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CountingBitsTest {
    private val sut = CountingBits.Solution()

    private data class TestData(val n: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(n = 2, result = intArrayOf(0, 1, 1)),
                TestData(n = 5, result = intArrayOf(0, 1, 1, 2, 1, 2)),
            )

        tests.forEach { test -> assertThat(sut.countBits(test.n)).isEqualTo(test.result) }
    }
}
