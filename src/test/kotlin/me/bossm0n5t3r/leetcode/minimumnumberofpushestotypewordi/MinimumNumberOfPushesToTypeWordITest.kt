package me.bossm0n5t3r.leetcode.minimumnumberofpushestotypewordi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPushesToTypeWordITest {
    private val sut = MinimumNumberOfPushesToTypeWordI.Solution()

    private data class TestData(val word: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abcde", 5),
                TestData("abcdefgh", 8),
                TestData("abcdefghi", 10),
                TestData("xycdefghij", 12),
                TestData("abcdefghijklmnop", 24),
                TestData("abcdefghijklmnopq", 27),
                TestData("abcdefghijklmnopqrstuvwxyz", 56),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumPushes(testData.word))
        }
    }
}
