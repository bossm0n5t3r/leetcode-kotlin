package me.bossm0n5t3r.leetcode.addbinary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddBinaryTest {
    private val sut = AddBinary.Solution()

    private data class TestData(val a: String, val b: String, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData("11", "1", "100"), TestData("1010", "1011", "10101"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.addBinary(testData.a, testData.b))
        }
    }
}
