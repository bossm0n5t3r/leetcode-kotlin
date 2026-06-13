package me.bossm0n5t3r.leetcode.rottingOranges

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RottingOrangesTest {
    private val sut = RottingOranges.Solution()

    private data class TestData(val grid: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

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
    fun test() {
        val tests =
            listOf(
                TestData(grid = "[[2,1,1],[1,1,0],[0,1,1]]".toArrayOfIntArray(), result = 4),
                TestData(grid = "[[2,1,1],[0,1,1],[1,0,1]]".toArrayOfIntArray(), result = -1),
                TestData(grid = "[[0,2]]".toArrayOfIntArray(), result = 0),
                TestData(grid = "[[0]]".toArrayOfIntArray(), result = 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.orangesRotting(test.grid)) }
    }
}
