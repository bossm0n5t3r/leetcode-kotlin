package me.bossm0n5t3r.leetcode.countvowelstringsinranges

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test

class CountVowelStringsInRangesTest {
    private val sut = CountVowelStringsInRanges.Solution()

    private data class TestData(
        val words: Array<String>,
        val queries: Array<IntArray>,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words.contentEquals(other.words)) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[\"aba\",\"bcb\",\"ece\",\"aa\",\"e\"]".toArrayOfString(),
                    "[[0,2],[1,4],[1,1]]".toArrayOfIntArray(),
                    "[2,3,0]".toIntArray(),
                ),
                TestData(
                    "[\"a\",\"e\",\"i\"]".toArrayOfString(),
                    "[[0,2],[0,1],[2,2]]".toArrayOfIntArray(),
                    "[3,2,1]".toIntArray(),
                ),
            )

        for (testData in testDataList) {
            testData.result.contentEquals(sut.vowelStrings(testData.words, testData.queries))
        }
    }
}
