package me.bossm0n5t3r.leetcode.integerToEnglishWords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerToEnglishWordsTest {
    private val sut = IntegerToEnglishWords.Solution()

    private data class TestData(val num: Int, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(123, "One Hundred Twenty Three"),
                TestData(12345, "Twelve Thousand Three Hundred Forty Five"),
                TestData(
                    1234567,
                    "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.numberToWords(test.num)) }
    }
}
