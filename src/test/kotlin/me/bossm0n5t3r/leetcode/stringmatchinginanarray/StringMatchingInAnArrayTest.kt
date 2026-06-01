package me.bossm0n5t3r.leetcode.stringmatchinginanarray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringMatchingInAnArrayTest {
    private val sut = StringMatchingInAnArray.Solution()

    private data class TestData(val words: Array<String>, val result: List<String>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words.contentEquals(other.words)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[\"mass\",\"as\",\"hero\",\"superhero\"]".toArrayOfString(),
                    listOf("as", "hero"),
                ),
                TestData("[\"leetcode\",\"et\",\"code\"]".toArrayOfString(), listOf("et", "code")),
                TestData("[\"blue\",\"green\",\"bu\"]".toArrayOfString(), emptyList()),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.stringMatching(testData.words))
        }
    }
}
