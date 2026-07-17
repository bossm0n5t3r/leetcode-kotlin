package me.bossm0n5t3r.leetcode.sortedgcdpairqueries

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortedGCDPairQueriesTest {
    private val sut = SortedGCDPairQueries.Solution()

    private data class TestData(val nums: IntArray, val queries: LongArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (!queries.contentEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + queries.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 3, 4), longArrayOf(0, 2, 2), intArrayOf(1, 2, 2)),
                TestData(intArrayOf(4, 4, 2, 1), longArrayOf(5, 3, 1, 0), intArrayOf(4, 2, 1, 1)),
                TestData(intArrayOf(2, 2), longArrayOf(0, 0), intArrayOf(2, 2)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.gcdValues(testData.nums, testData.queries).toList(),
            )
        }
    }
}
