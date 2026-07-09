package me.bossm0n5t3r.leetcode.pathexistencequeriesinagraphi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathExistenceQueriesInAGraphITest {
    private val sut = PathExistenceQueriesInAGraphI.Solution()

    private data class TestData(
        val n: Int,
        val nums: IntArray,
        val maxDiff: Int,
        val queries: Array<IntArray>,
        val result: BooleanArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (maxDiff != other.maxDiff) return false
            if (!nums.contentEquals(other.nums)) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + maxDiff
            result1 = 31 * result1 + nums.contentHashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    2,
                    intArrayOf(1, 3),
                    1,
                    "[[0,0],[0,1]]".toArrayOfIntArray(),
                    booleanArrayOf(true, false),
                ),
                TestData(
                    4,
                    intArrayOf(2, 5, 6, 8),
                    2,
                    "[[0,1],[0,2],[1,3],[2,3]]".toArrayOfIntArray(),
                    booleanArrayOf(false, false, true, true),
                ),
                TestData(
                    2,
                    intArrayOf(2975, 50642),
                    6,
                    "[[1,0]]".toArrayOfIntArray(),
                    booleanArrayOf(false),
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.pathExistenceQueries(
                        testData.n,
                        testData.nums,
                        testData.maxDiff,
                        testData.queries,
                    )
                    .toList(),
            )
        }
    }
}
