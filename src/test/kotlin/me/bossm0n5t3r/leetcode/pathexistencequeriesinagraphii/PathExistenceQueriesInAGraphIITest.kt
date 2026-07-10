package me.bossm0n5t3r.leetcode.pathexistencequeriesinagraphii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathExistenceQueriesInAGraphIITest {
    private val sut = PathExistenceQueriesInAGraphII.Solution()

    private data class TestData(
        val n: Int,
        val nums: IntArray,
        val maxDiff: Int,
        val queries: Array<IntArray>,
        val result: IntArray,
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
                    5,
                    intArrayOf(1, 8, 3, 4, 2),
                    3,
                    "[[0,3],[2,4]]".toArrayOfIntArray(),
                    intArrayOf(1, 1),
                ),
                TestData(
                    5,
                    intArrayOf(5, 3, 1, 9, 10),
                    2,
                    "[[0,1],[0,2],[2,3],[4,3]]".toArrayOfIntArray(),
                    intArrayOf(1, 2, -1, 1),
                ),
                TestData(
                    3,
                    intArrayOf(3, 6, 1),
                    1,
                    "[[0,0],[0,1],[1,2]]".toArrayOfIntArray(),
                    intArrayOf(0, -1, -1),
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
