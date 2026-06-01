package me.bossm0n5t3r.leetcode.shortestpathinagridwithobstacleselimination

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestPathInAGridWithObstaclesEliminationTest {
    private val sut = ShortestPathInAGridWithObstaclesElimination.Solution()

    private data class TestData(val grid: Array<IntArray>, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (result != other.result) return false
            if (!grid.contentDeepEquals(other.grid)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + result
            result1 = 31 * result1 + grid.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]]".toArrayOfIntArray(), 1, 6),
                TestData("[[0,1,1],[1,1,1],[1,0,0]]".toArrayOfIntArray(), 1, -1),
                TestData(
                    "[[0,1,0,0,0,1,0,0],[0,1,0,1,0,1,0,1],[0,0,0,1,0,0,1,0]]".toArrayOfIntArray(),
                    1,
                    13,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.shortestPath(testData.grid, testData.k))
        }
    }
}
