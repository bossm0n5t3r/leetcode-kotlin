package me.bossm0n5t3r.leetcode.countunguardedcellsinthegrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountUnguardedCellsInTheGridTest {
    private val sut = CountUnguardedCellsInTheGrid.Solution()

    private data class TestData(
        val m: Int,
        val n: Int,
        val guards: Array<IntArray>,
        val walls: Array<IntArray>,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (m != other.m) return false
            if (n != other.n) return false
            if (result != other.result) return false
            if (!guards.contentDeepEquals(other.guards)) return false
            if (!walls.contentDeepEquals(other.walls)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = m
            result1 = 31 * result1 + n
            result1 = 31 * result1 + result
            result1 = 31 * result1 + guards.contentDeepHashCode()
            result1 = 31 * result1 + walls.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    4,
                    6,
                    "[[0,0],[1,1],[2,3]]".toArrayOfIntArray(),
                    "[[0,1],[2,2],[1,4]]".toArrayOfIntArray(),
                    7,
                ),
                TestData(
                    3,
                    3,
                    "[[1,1]]".toArrayOfIntArray(),
                    "[[0,1],[1,0],[2,1],[1,2]]".toArrayOfIntArray(),
                    4,
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.countUnguarded(testData.m, testData.n, testData.guards, testData.walls),
            )
        }
    }
}
