package me.bossm0n5t3r.leetcode.findtheoriginaltypedstringi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheOriginalTypedStringITest {
    private val sut = FindTheOriginalTypedStringI.Solution()

    private data class TestData(val word: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abbcccc", 5), TestData("abcd", 1), TestData("aaaa", 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.possibleStringCount(testData.word))
        }
    }
}
