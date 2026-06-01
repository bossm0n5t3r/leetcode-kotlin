package me.bossm0n5t3r.leetcode.partitionArrayForMaximumSum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionArrayForMaximumSumTest {
    private val sut = PartitionArrayForMaximumSum.Solution()

    private data class TestData(val arr: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 15, 7, 9, 2, 5, 10), 3, 84),
                TestData(intArrayOf(1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3), 4, 83),
                TestData(intArrayOf(1), 1, 1),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.maxSumAfterPartitioning(test.arr, test.k))
        }
    }
}
