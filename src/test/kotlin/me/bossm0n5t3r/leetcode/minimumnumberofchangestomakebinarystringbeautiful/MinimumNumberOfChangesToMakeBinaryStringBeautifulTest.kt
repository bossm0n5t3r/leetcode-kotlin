package me.bossm0n5t3r.leetcode.minimumnumberofchangestomakebinarystringbeautiful

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfChangesToMakeBinaryStringBeautifulTest {
    private val sut = MinimumNumberOfChangesToMakeBinaryStringBeautiful.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("1001", 2), TestData("10", 1), TestData("0000", 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minChanges(testData.s))
        }
    }
}
