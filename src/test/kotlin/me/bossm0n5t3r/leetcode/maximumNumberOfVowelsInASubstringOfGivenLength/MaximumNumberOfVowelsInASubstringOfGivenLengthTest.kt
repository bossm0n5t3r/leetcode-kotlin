package me.bossm0n5t3r.leetcode.maximumNumberOfVowelsInASubstringOfGivenLength

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfVowelsInASubstringOfGivenLengthTest {
    private val sut = MaximumNumberOfVowelsInASubstringOfGivenLength.Solution()

    private data class TestData(val s: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(s = "abciiidef", k = 3, result = 3),
                TestData(s = "aeiou", k = 2, result = 2),
                TestData(s = "leetcode", k = 3, result = 2),
            )

        tests.forEach { test -> assertEquals(sut.maxVowels(test.s, test.k), test.result) }
    }
}
