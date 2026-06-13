package me.bossm0n5t3r.leetcode.runningSumOf1dArray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class RunningSumOf1dArrayTest {
    private val runningSumOf1dArray = RunningSumOf1dArray.Solution()

    private data class RunningSumOf1dArrayTestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as RunningSumOf1dArrayTestData

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
    fun runningSum() {
        val tests =
            listOf(
                RunningSumOf1dArrayTestData(intArrayOf(1, 2, 3, 4), intArrayOf(1, 3, 6, 10)),
                RunningSumOf1dArrayTestData(intArrayOf(1, 1, 1, 1, 1), intArrayOf(1, 2, 3, 4, 5)),
                RunningSumOf1dArrayTestData(intArrayOf(3, 1, 2, 10, 1), intArrayOf(3, 4, 6, 16, 17)),
            )
        tests.forEach { test ->
            runningSumOf1dArray.runningSum(test.nums).also { assertArrayEquals(it, test.result) }
        }
    }
}
