package me.bossm0n5t3r.leetcode.findwordscontainingcharacter

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindWordsContainingCharacterTest {
    private val sut = FindWordsContainingCharacter.Solution()

    private data class TestData(val words: Array<String>, val x: Char, val result: List<Int>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (x != other.x) return false
            if (!words.contentEquals(other.words)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = x.hashCode()
            result1 = 31 * result1 + words.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[\"leet\",\"code\"]".toArrayOfString(), 'e', listOf(0, 1)),
                TestData("[\"abc\",\"bcd\",\"aaaa\",\"cbc\"]".toArrayOfString(), 'a', listOf(0, 2)),
                TestData("[\"abc\",\"bcd\",\"aaaa\",\"cbc\"]".toArrayOfString(), 'z', listOf()),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findWordsContaining(testData.words, testData.x))
        }
    }
}
