package me.bossm0n5t3r.leetcode.processstringwithspecialoperationsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProcessStringWithSpecialOperationsITest {
    private val sut = ProcessStringWithSpecialOperationsI.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData("a#b%*", "ba"), TestData("z*#", ""))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.processStr(testData.s))
        }
    }
}
