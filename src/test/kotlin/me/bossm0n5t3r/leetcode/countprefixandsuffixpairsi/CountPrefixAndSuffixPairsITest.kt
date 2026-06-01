package me.bossm0n5t3r.leetcode.countprefixandsuffixpairsi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPrefixAndSuffixPairsITest {
    private val sut = CountPrefixAndSuffixPairsI.Solution()

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
                TestData("[\"a\",\"aba\",\"ababa\",\"aa\"]".toArrayOfString(), 4),
                TestData("[\"pa\",\"papa\",\"ma\",\"mama\"]".toArrayOfString(), 2),
                TestData("[\"abab\",\"ab\"]".toArrayOfString(), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countPrefixSuffixPairs(testData.words))
        }
    }
}
