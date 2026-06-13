package me.bossm0n5t3r.leetcode.shortestPathInBinaryMatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShortestPathInBinaryMatrixTest {
    private val shortestPathInBinaryMatrix = ShortestPathInBinaryMatrix.Solution()

    private data class ShortestPathInBinaryMatrixTestData(
        val grid: Array<IntArray>,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ShortestPathInBinaryMatrixTestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun shortestPathBinaryMatrix() {
        val tests =
            listOf(
                ShortestPathInBinaryMatrixTestData(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), 2),
                ShortestPathInBinaryMatrixTestData(
                    arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0)),
                    4,
                ),
                ShortestPathInBinaryMatrixTestData(
                    arrayOf(intArrayOf(1, 0, 0), intArrayOf(1, 1, 0), intArrayOf(1, 1, 0)),
                    -1,
                ),
                ShortestPathInBinaryMatrixTestData(
                    arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(1, 1, 0)),
                    3,
                ),
            )
        tests.forEach { test ->
            shortestPathInBinaryMatrix.shortestPathBinaryMatrix(test.grid).also {
                assertEquals(test.result, it)
            }
        }
    }
}
