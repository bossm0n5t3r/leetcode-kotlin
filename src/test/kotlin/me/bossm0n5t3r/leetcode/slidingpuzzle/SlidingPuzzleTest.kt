package me.bossm0n5t3r.leetcode.slidingpuzzle

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SlidingPuzzleTest {
    private val sut = SlidingPuzzle.Solution()

    private data class TestData(val board: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!board.contentDeepEquals(other.board)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + board.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,2,3],[4,0,5]]".toArrayOfIntArray(), 1),
                TestData("[[1,2,3],[5,4,0]]".toArrayOfIntArray(), -1),
                TestData("[[4,1,2],[5,0,3]]".toArrayOfIntArray(), 5),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.slidingPuzzle(testData.board))
        }
    }
}
