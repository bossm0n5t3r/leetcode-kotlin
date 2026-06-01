package me.bossm0n5t3r.leetcode.findkthbitinnthbinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindKthBitInNthBinaryStringTest {
    private val sut = FindKthBitInNthBinaryString.Solution()

    private data class TestData(val n: Int, val k: Int, val result: Char)

    @Test
    fun test() {
        val testDataList = listOf(TestData(3, 1, '0'), TestData(4, 11, '1'))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findKthBit(testData.n, testData.k))
        }
    }
}
