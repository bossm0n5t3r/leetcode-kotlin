package me.bossm0n5t3r.leetcode.countofsubstringscontainingeveryvowelandkconsonantsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountOfSubstringsContainingEveryVowelAndKConsonantsIITest {
    private val sut = CountOfSubstringsContainingEveryVowelAndKConsonantsII.Solution()

    private data class TestData(val word: String, val k: Int, val result: Long)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("aeioqq", 1, 0),
                TestData("aeiou", 0, 1),
                TestData("ieaouqqieaouqq", 1, 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countOfSubstrings(testData.word, testData.k))
        }
    }
}
