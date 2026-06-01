package me.bossm0n5t3r.leetcode.lettertilepossibilities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LetterTilePossibilitiesTest {
    private val sut = LetterTilePossibilities.Solution()

    private data class TestData(val tiles: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("AAB", 8), TestData("AAABBC", 188), TestData("V", 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numTilePossibilities(testData.tiles))
        }
    }
}
