package me.bossm0n5t3r.leetcode.shift2DGrid

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Shift2DGridTest {
    private val shift2DGrid = Shift2DGrid.Solution()

    private data class Shift2DGridTestData(
        val grid: Array<IntArray>,
        val k: Int,
        val result: List<List<Int>>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Shift2DGridTestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun shiftGrid() {
        val tests =
            listOf(
                Shift2DGridTestData(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                    1,
                    listOf(listOf(9, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8)),
                ),
                Shift2DGridTestData(
                    arrayOf(
                        intArrayOf(3, 8, 1, 9),
                        intArrayOf(19, 7, 2, 5),
                        intArrayOf(4, 6, 11, 10),
                        intArrayOf(12, 0, 21, 13),
                    ),
                    4,
                    listOf(
                        listOf(12, 0, 21, 13),
                        listOf(3, 8, 1, 9),
                        listOf(19, 7, 2, 5),
                        listOf(4, 6, 11, 10),
                    ),
                ),
                Shift2DGridTestData(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                    9,
                    listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)),
                ),
            )
        tests.forEach { test ->
            val result = shift2DGrid.shiftGrid(test.grid, test.k)
            println(result)
            assertThat(result).containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}
