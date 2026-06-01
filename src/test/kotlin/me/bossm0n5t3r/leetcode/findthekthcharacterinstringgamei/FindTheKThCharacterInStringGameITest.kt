package me.bossm0n5t3r.leetcode.findthekthcharacterinstringgamei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKThCharacterInStringGameITest {
    private val sut = FindTheKThCharacterInStringGameI.Solution()

    private data class TestData(val k: Int, val result: Char)

    @Test
    fun test() {
        val testDataList = listOf(TestData(5, 'b'), TestData(10, 'c'))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.kthCharacter(testData.k))
        }
    }
}
