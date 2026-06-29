package me.bossm0n5t3r.leetcode.numberofstringsthatappearassubstringsinword

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStringsThatAppearAsSubstringsInWordTest {
    private val sut = NumberOfStringsThatAppearAsSubstringsInWord.Solution()

    private data class TestData(val patterns: Array<String>, val word: String, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!patterns.contentEquals(other.patterns)) return false
            if (word != other.word) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + patterns.contentHashCode()
            result1 = 31 * result1 + word.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(arrayOf("a", "abc", "bc", "d"), "abc", 3),
                TestData(arrayOf("a", "b", "c"), "aaaaabbbbb", 2),
                TestData(arrayOf("a", "a", "a"), "ab", 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numOfStrings(testData.patterns, testData.word))
        }
    }
}
