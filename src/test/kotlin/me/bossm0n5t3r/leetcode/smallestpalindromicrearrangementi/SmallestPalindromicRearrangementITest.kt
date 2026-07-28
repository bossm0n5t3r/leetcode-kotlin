package me.bossm0n5t3r.leetcode.smallestpalindromicrearrangementi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestPalindromicRearrangementITest {
    private val sut = SmallestPalindromicRearrangementI.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("z", "z"), TestData("babab", "abbba"), TestData("daccad", "acddca"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestPalindrome(testData.s))
        }
    }
}
