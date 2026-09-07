package me.bossm0n5t3r.leetcode.distinctsubsequencesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistinctSubsequencesIITest {
    private val sut = DistinctSubsequencesII.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abc", 7), TestData("aba", 6), TestData("aaa", 3))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.distinctSubseqII(testData.s))
        }
    }
}
