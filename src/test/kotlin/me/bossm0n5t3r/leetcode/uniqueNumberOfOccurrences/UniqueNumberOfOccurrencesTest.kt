package me.bossm0n5t3r.leetcode.uniqueNumberOfOccurrences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueNumberOfOccurrencesTest {
    private val sut = UniqueNumberOfOccurrences.Solution()

    private data class TestData(val arr: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(arr = intArrayOf(1, 2, 2, 1, 1, 3), result = true),
                TestData(arr = intArrayOf(1, 2), result = false),
                TestData(arr = intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0), result = true),
            )

        tests.forEach { test -> assertEquals(test.result, sut.uniqueOccurrences(test.arr)) }
    }
}
