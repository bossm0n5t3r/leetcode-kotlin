package me.bossm0n5t3r.leetcode.sumofprefixscoresofstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfPrefixScoresOfStringsTest {
    private val sut = SumOfPrefixScoresOfStrings.Solution()

    private data class TestData(val words: Array<String>, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words.contentEquals(other.words)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(arrayOf("abc", "ab", "bc", "b"), intArrayOf(5, 4, 3, 2)),
                TestData(arrayOf("abcd"), intArrayOf(4)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.sumPrefixScores(testData.words).toList())
        }
    }
}
