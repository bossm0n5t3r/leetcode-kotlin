package me.bossm0n5t3r.leetcode.minimizexor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeXORTest {
    private val sut = MinimizeXOR.Solution()

    private data class TestData(val num1: Int, val num2: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(3, 5, 3), TestData(1, 12, 3))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimizeXor(testData.num1, testData.num2))
        }
    }
}
