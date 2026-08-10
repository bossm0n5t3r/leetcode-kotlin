package me.bossm0n5t3r.leetcode.stonegameiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StoneGameIVTest {
    private val sut = StoneGameIV.Solution()

    private data class TestData(val n: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1, true), TestData(2, false), TestData(4, true))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.winnerSquareGame(testData.n))
        }
    }
}
