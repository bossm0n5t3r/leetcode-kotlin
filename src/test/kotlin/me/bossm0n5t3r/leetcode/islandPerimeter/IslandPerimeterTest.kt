package me.bossm0n5t3r.leetcode.islandPerimeter

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IslandPerimeterTest {
    private val sut = IslandPerimeter.Solution()

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
                TestData("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]".toArrayOfIntArray(), 16),
                TestData("[[1]]".toArrayOfIntArray(), 4),
                TestData("[[1,0]]".toArrayOfIntArray(), 4),
            )

        tests.forEach { test -> assertEquals(test.result, sut.islandPerimeter(test.grid)) }
    }
}
