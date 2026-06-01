package me.bossm0n5t3r.leetcode.longestpalindromebyconcatenatingtwoletterwords

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromeByConcatenatingTwoLetterWordsTest {
    private val sut = LongestPalindromeByConcatenatingTwoLetterWords.Solution()

    private data class TestData(val words: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!words.contentEquals(other.words)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + words.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[\"lc\",\"cl\",\"gg\"]".toArrayOfString(), 6),
                TestData("[\"ab\",\"ty\",\"yt\",\"lc\",\"cl\",\"ab\"]".toArrayOfString(), 8),
                TestData("[\"cc\",\"ll\",\"xx\"]".toArrayOfString(), 2),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.longestPalindrome(testData.words))
        }
    }
}
