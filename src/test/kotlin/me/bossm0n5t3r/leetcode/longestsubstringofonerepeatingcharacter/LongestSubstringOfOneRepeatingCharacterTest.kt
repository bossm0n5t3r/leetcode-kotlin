package me.bossm0n5t3r.leetcode.longestsubstringofonerepeatingcharacter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubstringOfOneRepeatingCharacterTest {
    private val sut = LongestSubstringOfOneRepeatingCharacter.Solution()

    private data class TestData(
        val s: String,
        val queryCharacters: String,
        val queryIndices: IntArray,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s != other.s) return false
            if (queryCharacters != other.queryCharacters) return false
            if (!queryIndices.contentEquals(other.queryIndices)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s.hashCode()
            result1 = 31 * result1 + queryCharacters.hashCode()
            result1 = 31 * result1 + queryIndices.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("babacc", "bcb", intArrayOf(1, 3, 3), intArrayOf(3, 3, 4)),
                TestData("abyzz", "aa", intArrayOf(2, 1), intArrayOf(2, 3)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.longestRepeating(testData.s, testData.queryCharacters, testData.queryIndices)
                    .toList(),
            )
        }
    }
}
