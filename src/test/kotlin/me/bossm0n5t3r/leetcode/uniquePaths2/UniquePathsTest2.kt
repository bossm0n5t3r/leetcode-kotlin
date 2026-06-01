package me.bossm0n5t3r.leetcode.uniquePaths2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsTest2 {
    private val uniquePaths2 = UniquePaths2.Solution()

    data class UniquePaths2TestData(val obstacleGrid: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as UniquePaths2TestData

            if (!obstacleGrid.contentDeepEquals(other.obstacleGrid)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = obstacleGrid.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun uniquePathsWithObstacles() {
        val tests =
            listOf(
                UniquePaths2TestData(
                    obstacleGrid =
                        arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)),
                    result = 2,
                ),
                UniquePaths2TestData(
                    obstacleGrid = arrayOf(intArrayOf(0, 1), intArrayOf(0, 0)),
                    result = 1,
                ),
                UniquePaths2TestData(obstacleGrid = arrayOf(intArrayOf(1, 0)), result = 0),
                UniquePaths2TestData(
                    obstacleGrid = arrayOf(intArrayOf(1), intArrayOf(0)),
                    result = 0,
                ),
                UniquePaths2TestData(
                    obstacleGrid = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(0, 0)),
                    result = 0,
                ),
            )
        tests.forEach { test ->
            assertEquals(uniquePaths2.uniquePathsWithObstacles(test.obstacleGrid), test.result)
        }
    }
}
