package me.bossm0n5t3r.leetcode.minimumnumberofflipstomakethebinarystringalternating

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToMakeTheBinaryStringAlternatingTest {
    private val sut = MinimumNumberOfFlipsToMakeTheBinaryStringAlternating.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("111000", 2), TestData("010", 0), TestData("1110", 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minFlips(testData.s))
        }
    }
}
