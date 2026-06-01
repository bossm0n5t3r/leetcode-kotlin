package me.bossm0n5t3r.leetcode.maximumdifferencebetweenevenandoddfrequencyi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenEvenAndOddFrequencyITest {
    private val sut = MaximumDifferenceBetweenEvenAndOddFrequencyI.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("aaaaabbc", 3), TestData("abcabcab", 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxDifference(testData.s))
        }
    }
}
