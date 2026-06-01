package me.bossm0n5t3r.leetcode.maximumscorefromremovingsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreFromRemovingSubstringsTest {
    private val sut = MaximumScoreFromRemovingSubstrings.Solution()

    private data class TestData(val s: String, val x: Int, val y: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("cdbcbbaaabab", 4, 5, 19), TestData("aabbaaxybbaabb", 5, 4, 20))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maximumGain(testData.s, testData.x, testData.y))
        }
    }
}
