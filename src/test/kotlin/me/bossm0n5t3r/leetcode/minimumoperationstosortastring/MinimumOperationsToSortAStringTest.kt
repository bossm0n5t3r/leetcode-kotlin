package me.bossm0n5t3r.leetcode.minimumoperationstosortastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToSortAStringTest {
    private val sut = MinimumOperationsToSortAString.Solution()

    private class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("dog", 1), TestData("card", 2), TestData("gf", -1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minOperations(testData.s))
        }
    }
}
