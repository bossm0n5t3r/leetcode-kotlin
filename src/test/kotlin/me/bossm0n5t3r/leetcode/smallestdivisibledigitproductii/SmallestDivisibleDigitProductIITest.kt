package me.bossm0n5t3r.leetcode.smallestdivisibledigitproductii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestDivisibleDigitProductIITest {
    private val sut = SmallestDivisibleDigitProductII.Solution()

    private data class TestData(val num: String, val t: Long, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("1234", 256, "1488"),
                TestData("12355", 50, "12355"),
                TestData("11111", 26, "-1"),
                TestData("4093", 180, "4159"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestNumber(testData.num, testData.t))
        }
    }
}
