package me.bossm0n5t3r.leetcode.lexicographicallyminimumstringafterremovingstars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallyMinimumStringAfterRemovingStarsTest {
    private val sut = LexicographicallyMinimumStringAfterRemovingStars.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData("aaba*", "aab"), TestData("abc", "abc"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.clearStars(testData.s))
        }
    }
}
