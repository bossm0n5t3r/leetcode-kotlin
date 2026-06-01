package me.bossm0n5t3r.leetcode.checkbalancedstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckBalancedStringTest {
    private val sut = CheckBalancedString.Solution()

    private data class TestData(val num: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList = listOf(TestData("1234", false), TestData("24123", true))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.isBalanced(testData.num))
        }
    }
}
