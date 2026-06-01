package me.bossm0n5t3r.leetcode.longesthappystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestHappyStringTest {
    private val sut = LongestHappyString.Solution()

    private data class TestData(val a: Int, val b: Int, val c: Int, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1, 1, 7, "ccaccbcc"), TestData(7, 1, 0, "aabaa"))

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.longestDiverseString(testData.a, testData.b, testData.c),
            )
        }
    }
}
