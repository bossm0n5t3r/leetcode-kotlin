package me.bossm0n5t3r.leetcode.numberofpathswithmaxscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfPathsWithMaxScoreTest {
    private val sut = NumberOfPathsWithMaxScore.Solution()

    private data class TestData(val board: List<String>, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (board != other.board) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = board.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(listOf("E23", "2X2", "12S"), intArrayOf(7, 1)),
                TestData(listOf("E12", "1X1", "21S"), intArrayOf(4, 2)),
                TestData(listOf("E11", "XXX", "11S"), intArrayOf(0, 0)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.pathsWithMaxScore(testData.board).toList())
        }
    }
}
