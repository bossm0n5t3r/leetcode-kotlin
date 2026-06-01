package me.bossm0n5t3r.leetcode.maximumnumberofpointsfromgridqueries

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MaximumNumberOfPointsFromGridQueriesTest {
    private val sut = MaximumNumberOfPointsFromGridQueries.Solution()

    private data class TestData(
        val grid: Array<IntArray>,
        val queries: IntArray,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (!queries.contentEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + queries.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,2,3],[2,5,7],[3,5,1]]".toArrayOfIntArray(),
                    "[5,6,2]".toIntArray(),
                    "[5,8,1]".toIntArray(),
                ),
                TestData(
                    "[[5,2,1],[1,1,2]]".toArrayOfIntArray(),
                    "[3]".toIntArray(),
                    "[0]".toIntArray(),
                ),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.maxPoints(testData.grid, testData.queries))
            }
        }
    }
}
