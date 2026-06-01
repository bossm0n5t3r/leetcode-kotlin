package me.bossm0n5t3r.leetcode.kthsmallestinlexicographicalorder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KThSmallestInLexicographicalOrderTest {
    private val sut = KThSmallestInLexicographicalOrder.Solution()

    private data class TestData(val n: Int, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(13, 2, 10),
                TestData(1, 1, 1),
                TestData(681692778, 351251360, 416126219),
                TestData(957747794, 424238336, 481814499),
                TestData(10000, 10000, 9999),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findKthNumber(testData.n, testData.k))
        }
    }
}
