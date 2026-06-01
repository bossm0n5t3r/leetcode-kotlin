package me.bossm0n5t3r.leetcode.specialbinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpecialBinaryStringTest {
    private val sut = SpecialBinaryString.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData("11011000", "11100100"), TestData("10", "10"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.makeLargestSpecial(testData.s))
        }
    }
}
