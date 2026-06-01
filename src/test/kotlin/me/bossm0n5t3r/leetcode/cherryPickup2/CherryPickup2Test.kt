package me.bossm0n5t3r.leetcode.cherryPickup2

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CherryPickup2Test {
    private val sut = CherryPickup2.Solution()

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
                TestData("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]".toArrayOfIntArray(), 24),
                TestData(
                    "[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]"
                        .toArrayOfIntArray(),
                    28,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.cherryPickup(test.grid)) }
    }
}
