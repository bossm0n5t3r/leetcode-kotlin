package me.bossm0n5t3r.leetcode.magicSquaresInGrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MagicSquaresInGridTest {
    private val sut = MagicSquaresInGrid.Solution()

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
                TestData("[[4,3,8,4],[9,5,1,9],[2,7,6,2]]".toArrayOfIntArray(), 1),
                TestData("[[8]]".toArrayOfIntArray(), 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.numMagicSquaresInside(test.grid)) }
    }
}
