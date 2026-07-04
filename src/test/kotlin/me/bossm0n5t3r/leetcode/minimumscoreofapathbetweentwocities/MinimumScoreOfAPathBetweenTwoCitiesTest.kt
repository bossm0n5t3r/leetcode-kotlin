package me.bossm0n5t3r.leetcode.minimumscoreofapathbetweentwocities

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumScoreOfAPathBetweenTwoCitiesTest {
    private val sut = MinimumScoreOfAPathBetweenTwoCities.Solution()

    private data class TestData(val n: Int, val roads: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (result != other.result) return false
            if (!roads.contentDeepEquals(other.roads)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result
            result1 = 31 * result1 + roads.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(4, "[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]".toArrayOfIntArray(), 5),
                TestData(4, "[[1,2,2],[1,3,4],[3,4,7]]".toArrayOfIntArray(), 2),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minScore(testData.n, testData.roads))
        }
    }
}
