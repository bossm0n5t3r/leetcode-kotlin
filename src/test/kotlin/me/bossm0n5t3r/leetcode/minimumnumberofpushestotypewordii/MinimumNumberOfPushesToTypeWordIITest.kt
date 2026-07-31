package me.bossm0n5t3r.leetcode.minimumnumberofpushestotypewordii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPushesToTypeWordIITest {
    private val sut = MinimumNumberOfPushesToTypeWordII.Solution()

    private data class TestData(val word: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abcde", 5),
                TestData("xyzxyzxyzxyz", 12),
                TestData("aabbccddeeffgghhiiiiii", 24),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumPushes(testData.word))
        }
    }
}
