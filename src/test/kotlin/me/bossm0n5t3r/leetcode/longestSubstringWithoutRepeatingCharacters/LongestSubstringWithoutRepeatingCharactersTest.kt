package me.bossm0n5t3r.leetcode.longestSubstringWithoutRepeatingCharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongestSubstringWithoutRepeatingCharactersTest {
    private val longestSubstringWithoutRepeatingCharacters =
        LongestSubstringWithoutRepeatingCharacters.Solution()

    private data class LongestSubstringWithoutRepeatingCharactersTestData(
        val s: String,
        val result: Int,
    )

    @Test
    fun lengthOfLongestSubstring() {
        val tests =
            listOf(
                LongestSubstringWithoutRepeatingCharactersTestData("abcabcbb", 3),
                LongestSubstringWithoutRepeatingCharactersTestData("bbbbb", 1),
                LongestSubstringWithoutRepeatingCharactersTestData("pwwkew", 3),
                LongestSubstringWithoutRepeatingCharactersTestData("au", 2),
                LongestSubstringWithoutRepeatingCharactersTestData("", 0),
                LongestSubstringWithoutRepeatingCharactersTestData("a", 1),
                LongestSubstringWithoutRepeatingCharactersTestData("aab", 2),
            )
        tests.forEach { test ->
            println(test.s)
            assertEquals(
                longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(test.s),
                test.result,
            )
        }
    }
}
