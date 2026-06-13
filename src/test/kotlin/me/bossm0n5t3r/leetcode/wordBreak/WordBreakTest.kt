package me.bossm0n5t3r.leetcode.wordBreak

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordBreakTest {
    private val wordBreak = WordBreak.Solution()

    data class WordBreakTestData(val s: String, val wordDict: List<String>, val result: Boolean)

    @Test
    fun wordBreak() {
        val tests =
            listOf(
                WordBreakTestData(s = "leetcode", wordDict = listOf("leet", "code"), result = true),
                WordBreakTestData(
                    s = "applepenapple",
                    wordDict = listOf("apple", "pen"),
                    result = true,
                ),
                WordBreakTestData(
                    s = "catsandog",
                    wordDict = listOf("cats", "dog", "sand", "and", "cat"),
                    result = false,
                ),
                WordBreakTestData(s = "cars", wordDict = listOf("car", "ca", "rs"), result = true),
            )
        tests.forEach { test ->
            assertEquals(test.result, wordBreak.wordBreak(test.s, test.wordDict))
        }
    }
}
