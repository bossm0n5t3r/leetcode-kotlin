package me.bossm0n5t3r.leetcode.minimumFallingPathSumTwo

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFallingPathSumTwoTest {
    private val sut = MinimumFallingPathSumTwo.Solution()

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
                TestData("[[1,2,3],[4,5,6],[7,8,9]]".toArrayOfIntArray(), 13),
                TestData("[[7]]".toArrayOfIntArray(), 7),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minFallingPathSum(test.grid)) }
    }
}
