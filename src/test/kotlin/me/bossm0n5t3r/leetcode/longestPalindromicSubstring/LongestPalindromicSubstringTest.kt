package me.bossm0n5t3r.leetcode.longestPalindromicSubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongestPalindromicSubstringTest {
    private val longestPalindromicSubstring = LongestPalindromicSubstring.Solution()

    private data class LongestPalindromicSubstringTestData(val s: String, val result: String)

    @Test
    fun longestPalindrome() {
        val tests =
            listOf(
                LongestPalindromicSubstringTestData("babad", "bab"),
                LongestPalindromicSubstringTestData("cbbd", "bb"),
                LongestPalindromicSubstringTestData("a", "a"),
                LongestPalindromicSubstringTestData("ac", "a"),
                LongestPalindromicSubstringTestData("ccc", "ccc"),
                LongestPalindromicSubstringTestData("aaaa", "aaaa"),
            )
        tests.forEach { test ->
            println(longestPalindromicSubstring.longestPalindrome(test.s))
            assertEquals(longestPalindromicSubstring.longestPalindrome(test.s), test.result)
        }
    }
}
