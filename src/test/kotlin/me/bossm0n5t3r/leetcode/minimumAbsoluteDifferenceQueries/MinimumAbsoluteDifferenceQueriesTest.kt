package me.bossm0n5t3r.leetcode.minimumAbsoluteDifferenceQueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class MinimumAbsoluteDifferenceQueriesTest {
    private val sut = MinimumAbsoluteDifferenceQueries.Solution()

    private data class Example(
        val nums: IntArray,
        val queries: Array<IntArray>,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Example

            if (!nums.contentEquals(other.nums)) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun minDifference() {
        val tests =
            listOf(
                Example(
                    intArrayOf(1, 3, 4, 8),
                    arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(0, 3)),
                    intArrayOf(2, 1, 4, 1),
                ),
                Example(
                    intArrayOf(4, 5, 2, 2, 7, 10),
                    arrayOf(intArrayOf(2, 3), intArrayOf(0, 2), intArrayOf(0, 5), intArrayOf(3, 5)),
                    intArrayOf(-1, 1, 1, 3),
                ),
                Example(
                    intArrayOf(4, 6, 2, 2, 7),
                    arrayOf(
                        intArrayOf(0, 3),
                        intArrayOf(2, 4),
                        intArrayOf(0, 4),
                        intArrayOf(0, 4),
                        intArrayOf(0, 3),
                    ),
                    intArrayOf(2, 5, 1, 1, 2),
                ),
            )
        tests.forEach { test ->
            sut.minDifference(test.nums, test.queries).also {
                println(it.toList())
                assertArrayEquals(it, test.result)
            }
        }
    }
}
