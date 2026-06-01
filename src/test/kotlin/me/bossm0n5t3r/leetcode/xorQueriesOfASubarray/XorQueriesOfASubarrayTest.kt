package me.bossm0n5t3r.leetcode.xorQueriesOfASubarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class XorQueriesOfASubarrayTest {
    private val sut = XorQueriesOfASubarray.Solution()

    private data class TestData(
        val arr: IntArray,
        val queries: Array<IntArray>,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    intArrayOf(1, 3, 4, 8),
                    "[[0,1],[1,2],[0,3],[3,3]]".toArrayOfIntArray(),
                    intArrayOf(2, 7, 14, 8),
                ),
                TestData(
                    intArrayOf(4, 8, 2, 10),
                    "[[2,3],[1,3],[0,0],[0,3]]".toArrayOfIntArray(),
                    intArrayOf(8, 0, 4, 4),
                ),
            )

        tests.forEach { test ->
            assertTrue { sut.xorQueries(test.arr, test.queries).contentEquals(test.result) }
        }
    }
}
