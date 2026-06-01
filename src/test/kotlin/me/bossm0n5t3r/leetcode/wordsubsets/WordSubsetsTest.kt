package me.bossm0n5t3r.leetcode.wordsubsets

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordSubsetsTest {
    private val sut = WordSubsets.Solution()

    private data class TestData(
        val words1: Array<String>,
        val words2: Array<String>,
        val result: List<String>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!words1.contentEquals(other.words1)) return false
            if (!words2.contentEquals(other.words2)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = words1.contentHashCode()
            result1 = 31 * result1 + words2.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[\"amazon\",\"apple\",\"facebook\",\"google\",\"leetcode\"]".toArrayOfString(),
                    "[\"e\",\"o\"]".toArrayOfString(),
                    listOf("facebook", "google", "leetcode"),
                ),
                TestData(
                    "[\"amazon\",\"apple\",\"facebook\",\"google\",\"leetcode\"]".toArrayOfString(),
                    "[\"l\",\"e\"]".toArrayOfString(),
                    listOf("apple", "google", "leetcode"),
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.wordSubsets(testData.words1, testData.words2))
        }
    }
}
