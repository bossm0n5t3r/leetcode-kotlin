package me.bossm0n5t3r.leetcode.gridgame

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GridGameTest {
    private val sut = GridGame.Solution()

    private data class TestData(val grid: Array<IntArray>, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!grid.contentDeepEquals(other.grid)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + grid.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[2,5,4],[1,5,1]]".toArrayOfIntArray(), 4),
                TestData("[[3,3,1],[8,5,2]]".toArrayOfIntArray(), 4),
                TestData("[[1,3,1,15],[1,3,3,1]]".toArrayOfIntArray(), 7),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.gridGame(testData.grid))
        }
    }
}
