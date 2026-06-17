package me.bossm0n5t3r.leetcode.processstringwithspecialoperationsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProcessStringWithSpecialOperationsIITest {
    private val sut = ProcessStringWithSpecialOperationsII.Solution()

    private data class TestData(val s: String, val k: Long, val result: Char)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("a#b%*", 1, 'a'), TestData("cd%#*#", 3, 'd'), TestData("z*#", 0, '.'))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.processStr(testData.s, testData.k))
        }
    }
}
