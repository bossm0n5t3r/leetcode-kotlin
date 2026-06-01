package me.bossm0n5t3r.leetcode.minimumoperationstoequalizebinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToEqualizeBinaryStringTest {
    private val sut = MinimumOperationsToEqualizeBinaryString.Solution()

    private data class TestData(val s: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("110", 1, 1), TestData("0101", 3, 2), TestData("101", 2, -1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minOperations(testData.s, testData.k))
        }
    }
}
