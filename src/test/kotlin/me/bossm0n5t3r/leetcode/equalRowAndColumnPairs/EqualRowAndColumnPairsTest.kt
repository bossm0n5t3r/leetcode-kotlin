package me.bossm0n5t3r.leetcode.equalRowAndColumnPairs

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EqualRowAndColumnPairsTest {
    private val sut = EqualRowAndColumnPairs.Solution()

    private data class TestData(val grid: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(grid = "[[3,2,1],[1,7,6],[2,7,7]]".toArrayOfIntArray(), result = 1),
                TestData(
                    grid = "[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]".toArrayOfIntArray(),
                    result = 3,
                ),
                TestData(
                    grid = "[[3,1,2,2],[1,4,4,4],[2,4,2,2],[2,5,2,2]]".toArrayOfIntArray(),
                    result = 3,
                ),
                TestData(grid = "[[13,13],[13,13]]".toArrayOfIntArray(), result = 4),
            )

        tests.forEach { test -> assertEquals(sut.equalPairs(test.grid), test.result) }
    }
}
