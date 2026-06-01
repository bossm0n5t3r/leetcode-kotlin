package me.bossm0n5t3r.leetcode.longestCommonPrefix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixTest {
    private val longestCommonPrefix = LongestCommonPrefix.Solution()

    data class LongestCommonPrefixTestData(val strs: Array<String>, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as LongestCommonPrefixTestData

            if (!strs.contentEquals(other.strs)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = strs.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun longestCommonPrefix() {
        val tests =
            listOf(
                LongestCommonPrefixTestData(arrayOf("flower", "flow", "flight"), "fl"),
                LongestCommonPrefixTestData(arrayOf("dog", "racecar", "car"), ""),
                LongestCommonPrefixTestData(arrayOf(""), ""),
                LongestCommonPrefixTestData(arrayOf("abab", "aba", ""), ""),
            )
        tests.forEach { test ->
            assertEquals(test.result, longestCommonPrefix.longestCommonPrefixFirst(test.strs))
            assertEquals(test.result, longestCommonPrefix.longestCommonPrefixSecond(test.strs))
            assertEquals(test.result, longestCommonPrefix.longestCommonPrefixThird(test.strs))
            assertEquals(test.result, longestCommonPrefix.longestCommonPrefixFourth(test.strs))
            assertEquals(test.result, longestCommonPrefix.longestCommonPrefixTrie(test.strs))
            assertEquals(test.result, longestCommonPrefix.longestCommonPrefixAt20250109(test.strs))
        }
    }
}
