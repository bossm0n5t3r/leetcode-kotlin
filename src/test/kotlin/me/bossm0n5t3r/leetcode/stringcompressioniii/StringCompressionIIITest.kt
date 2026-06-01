package me.bossm0n5t3r.leetcode.stringcompressioniii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCompressionIIITest {
    private val sut = StringCompressionIII.Solution()

    private data class TestData(val word: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("abcde", "1a1b1c1d1e"), TestData("aaaaaaaaaaaaaabb", "9a5a2b"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.compressedString(testData.word))
        }
    }
}
