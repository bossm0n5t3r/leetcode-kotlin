package me.bossm0n5t3r.leetcode.deletecharacterstomakefancystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteCharactersToMakeFancyStringTest {
    private val sut = DeleteCharactersToMakeFancyString.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("leeetcode", "leetcode"),
                TestData("aaabaaaa", "aabaa"),
                TestData("aab", "aab"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.makeFancyString(testData.s))
        }
    }
}
