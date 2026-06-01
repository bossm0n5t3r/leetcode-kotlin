package me.bossm0n5t3r.leetcode.countgoodnumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodNumbersTest {
    private val sut = CountGoodNumbers.Solution()

    private data class TestData(val n: Long, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(1, 5),
                TestData(4, 400),
                TestData(50, 564908303),
                TestData(806166225460393, 643535977),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countGoodNumbers(testData.n))
        }
    }
}
