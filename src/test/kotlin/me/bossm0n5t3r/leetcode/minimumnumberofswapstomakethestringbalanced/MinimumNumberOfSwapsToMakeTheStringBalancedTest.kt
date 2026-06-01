package me.bossm0n5t3r.leetcode.minimumnumberofswapstomakethestringbalanced

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfSwapsToMakeTheStringBalancedTest {
    private val sut = MinimumNumberOfSwapsToMakeTheStringBalanced.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("][][", 1), TestData("]]][[[", 2), TestData("[]", 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minSwaps(testData.s))
        }
    }
}
