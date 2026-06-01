package me.bossm0n5t3r.leetcode.shortestdistanceafterroadadditionqueriesi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ShortestDistanceAfterRoadAdditionQueriesITest {
    private val sut = ShortestDistanceAfterRoadAdditionQueriesI.Solution()

    private data class TestData(val n: Int, val queries: Array<IntArray>, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(5, "[[2,4],[0,2],[0,4]]".toArrayOfIntArray(), "[3,2,1]".toIntArray()),
                TestData(4, "[[0,3],[0,2]]".toArrayOfIntArray(), "[1,1]".toIntArray()),
            )

        for (testData in testDataList) {
            assertArrayEquals(
                testData.result,
                sut.shortestDistanceAfterQueries(testData.n, testData.queries),
            )
        }
    }
}
