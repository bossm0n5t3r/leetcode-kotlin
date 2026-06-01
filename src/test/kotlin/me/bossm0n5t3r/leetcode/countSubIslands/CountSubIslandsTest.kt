package me.bossm0n5t3r.leetcode.countSubIslands

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubIslandsTest {
    private val sut = CountSubIslands.Solution()

    private data class TestData(
        val grid1: Array<IntArray>,
        val grid2: Array<IntArray>,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid1.contentDeepEquals(other.grid1)) return false
            if (!grid2.contentDeepEquals(other.grid2)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid1.contentDeepHashCode()
            result1 = 31 * result1 + grid2.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]"
                        .toArrayOfIntArray(),
                    "[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]"
                        .toArrayOfIntArray(),
                    3,
                ),
                TestData(
                    "[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]"
                        .toArrayOfIntArray(),
                    "[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]"
                        .toArrayOfIntArray(),
                    2,
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.countSubIslands(test.grid1, test.grid2))
        }
    }
}
