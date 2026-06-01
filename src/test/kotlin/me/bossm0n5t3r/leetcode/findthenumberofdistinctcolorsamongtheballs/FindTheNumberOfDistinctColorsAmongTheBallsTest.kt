package me.bossm0n5t3r.leetcode.findthenumberofdistinctcolorsamongtheballs

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindTheNumberOfDistinctColorsAmongTheBallsTest {
    private val sut = FindTheNumberOfDistinctColorsAmongTheBalls.Solution()

    private data class TestData(
        val limit: Int,
        val queries: Array<IntArray>,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (limit != other.limit) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = limit
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
                    4,
                    "[[1,4],[2,5],[1,3],[3,4]]".toArrayOfIntArray(),
                    "[1,2,2,3]".toIntArray(),
                ),
                TestData(
                    4,
                    "[[0,1],[1,2],[2,2],[3,4],[4,5]]".toArrayOfIntArray(),
                    "[1,2,2,3,4]".toIntArray(),
                ),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.queryResults(testData.limit, testData.queries))
            }
        }
    }
}
