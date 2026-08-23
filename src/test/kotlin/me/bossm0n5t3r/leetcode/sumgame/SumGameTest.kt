package me.bossm0n5t3r.leetcode.sumgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumGameTest {
    private val sut = SumGame.Solution()

    private data class TestData(val num: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("5023", false),
                TestData("25??", true),
                TestData("?3295???", false),
                TestData("0?", true),
                TestData("?0", true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sumGame(testData.num))
        }
    }
}
