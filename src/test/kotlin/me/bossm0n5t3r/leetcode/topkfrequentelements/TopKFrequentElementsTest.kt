package me.bossm0n5t3r.leetcode.topkfrequentelements

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TopKFrequentElementsTest {
    private val topKFrequentElements = TopKFrequentElements.Solution()

    data class TopKFrequentElementsTestData(val nums: IntArray, val k: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TopKFrequentElementsTestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun topKFrequent() {
        val tests =
            listOf(
                TopKFrequentElementsTestData(intArrayOf(1, 1, 1, 2, 2, 3), 2, intArrayOf(1, 2)),
                TopKFrequentElementsTestData(intArrayOf(1), 1, intArrayOf(1)),
                TopKFrequentElementsTestData(intArrayOf(1, 2), 2, intArrayOf(1, 2)),
            )
        tests.forEach { test ->
            val result = topKFrequentElements.topKFrequent(test.nums, test.k)
            assertTrue(result.contentEquals(test.result))
        }
    }
}
