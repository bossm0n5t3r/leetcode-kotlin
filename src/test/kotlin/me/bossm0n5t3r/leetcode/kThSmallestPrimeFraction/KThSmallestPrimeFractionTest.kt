package me.bossm0n5t3r.leetcode.kThSmallestPrimeFraction

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KThSmallestPrimeFractionTest {
    private val sut = KThSmallestPrimeFraction.Solution()

    private data class TestData(val arr: IntArray, val k: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (k != other.k) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 3, 5), 3, intArrayOf(2, 5)),
                TestData(intArrayOf(1, 7), 1, intArrayOf(1, 7)),
            )

        tests.forEach { test ->
            assertTrue { test.result.contentEquals(sut.kthSmallestPrimeFraction(test.arr, test.k)) }
        }
    }
}
