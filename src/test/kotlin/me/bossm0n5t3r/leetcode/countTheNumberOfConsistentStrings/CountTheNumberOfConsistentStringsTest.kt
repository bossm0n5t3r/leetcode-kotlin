package me.bossm0n5t3r.leetcode.countTheNumberOfConsistentStrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfConsistentStringsTest {
    private val sut = CountTheNumberOfConsistentStrings.Solution()

    private data class TestData(val allowed: String, val words: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (allowed != other.allowed) return false
            if (!words.contentEquals(other.words)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = allowed.hashCode()
            result1 = 31 * result1 + words.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("ab", arrayOf("ad", "bd", "aaab", "baa", "badab"), 2),
                TestData("abc", arrayOf("a", "b", "c", "ab", "ac", "bc", "abc"), 7),
                TestData("cad", arrayOf("cc", "acd", "b", "ba", "bac", "bad", "ac", "d"), 4),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.countConsistentStrings(test.allowed, test.words))
        }
    }
}
