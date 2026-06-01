package me.bossm0n5t3r.leetcode.maximumNumberOfFishInAGrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfFishInAGridTest {
    private val sut = MaximumNumberOfFishInAGrid.Solution()

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
                TestData("[[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]".toArrayOfIntArray(), 7),
                TestData("[[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]".toArrayOfIntArray(), 1),
                TestData("[[10,5],[8,0]]".toArrayOfIntArray(), 23),
            )

        tests.forEach { test -> assertEquals(test.result, sut.findMaxFish(test.grid)) }
    }
}
