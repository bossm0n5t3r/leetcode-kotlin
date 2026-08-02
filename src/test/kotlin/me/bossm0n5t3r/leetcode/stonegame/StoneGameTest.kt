package me.bossm0n5t3r.leetcode.stonegame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StoneGameTest {
    private val sut = StoneGame.Solution()

    private data class TestData(val piles: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!piles.contentEquals(other.piles)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + piles.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(intArrayOf(5, 3, 4, 5), true), TestData(intArrayOf(3, 7, 2, 3), true))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.stoneGame(testData.piles))
        }
    }
}
