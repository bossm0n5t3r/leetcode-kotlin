package me.bossm0n5t3r.leetcode.pathWithMaximumGold

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathWithMaximumGoldTest {
    private val sut = PathWithMaximumGold.Solution()

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
                TestData("[[0,6,0],[5,8,7],[0,9,0]]".toArrayOfIntArray(), 24),
                TestData("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]".toArrayOfIntArray(), 28),
            )

        tests.forEach { test -> assertEquals(test.result, sut.getMaximumGold(test.grid)) }
    }
}
