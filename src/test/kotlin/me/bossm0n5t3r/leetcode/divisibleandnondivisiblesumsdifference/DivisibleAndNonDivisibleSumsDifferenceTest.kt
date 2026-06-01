package me.bossm0n5t3r.leetcode.divisibleandnondivisiblesumsdifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivisibleAndNonDivisibleSumsDifferenceTest {
    private val sut = DivisibleAndNonDivisibleSumsDifference.Solution()

    private data class TestData(val n: Int, val m: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(10, 3, 19), TestData(5, 6, 15), TestData(5, 1, -15))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.differenceOfSums(testData.n, testData.m))
        }
    }
}
