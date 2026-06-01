package me.bossm0n5t3r.leetcode.uncommonwordsfromtwosentences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UncommonWordsFromTwoSentencesTest {
    private val sut = UncommonWordsFromTwoSentences.Solution()

    private data class TestData(val s1: String, val s2: String, val result: Array<String>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s1 != other.s1) return false
            if (s2 != other.s2) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s1.hashCode()
            result1 = 31 * result1 + s2.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("this apple is sweet", "this apple is sour", arrayOf("sweet", "sour")),
                TestData("apple apple", "banana", arrayOf("banana")),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.uncommonFromSentences(testData.s1, testData.s2).toList(),
            )
        }
    }
}
