package me.bossm0n5t3r.leetcode.numberofzigzagarraysi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfZigzagArraysITest {
    private val sut = NumberOfZigzagArraysI.Solution()

    private data class TestData(val n: Int, val l: Int, val r: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(3, 4, 5, 2), TestData(3, 1, 3, 10))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.zigZagArrays(testData.n, testData.l, testData.r))
        }
    }
}
