package me.bossm0n5t3r.leetcode.sumOfSubarrayMinimums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSubarrayMinimumsTest {
    private val sut = SumOfSubarrayMinimums.Solution()

    private data class TestData(val arr: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(3, 1, 2, 4), 17),
                TestData(intArrayOf(11, 81, 94, 43, 3), 444),
            )

        tests.forEach { test -> assertEquals(test.result, sut.sumSubarrayMins(test.arr)) }
    }
}
