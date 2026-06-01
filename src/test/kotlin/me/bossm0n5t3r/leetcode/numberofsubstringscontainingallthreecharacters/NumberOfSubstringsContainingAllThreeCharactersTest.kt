package me.bossm0n5t3r.leetcode.numberofsubstringscontainingallthreecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubstringsContainingAllThreeCharactersTest {
    private val sut = NumberOfSubstringsContainingAllThreeCharacters.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abcabc", 10), TestData("aaacb", 3), TestData("abc", 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numberOfSubstrings(testData.s))
        }
    }
}
