package me.bossm0n5t3r.leetcode.countingwordswithagivenprefix

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountingWordsWithAGivenPrefixTest {
    private val sut = CountingWordsWithAGivenPrefix.Solution()

    private data class TestData(val words: Array<String>, val pref: String, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!words.contentEquals(other.words)) return false
            if (pref != other.pref) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + words.contentHashCode()
            result1 = 31 * result1 + pref.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[\"pay\",\"attention\",\"practice\",\"attend\"]".toArrayOfString(),
                    "at",
                    2,
                ),
                TestData(
                    "[\"leetcode\",\"win\",\"loops\",\"success\"]".toArrayOfString(),
                    "code",
                    0,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.prefixCount(testData.words, testData.pref))
        }
    }
}
