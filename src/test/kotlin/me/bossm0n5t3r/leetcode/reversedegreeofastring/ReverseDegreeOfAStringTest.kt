package me.bossm0n5t3r.leetcode.reversedegreeofastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseDegreeOfAStringTest {
    private val sut = ReverseDegreeOfAString.Solution()

    private class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abc", 148), TestData("zaza", 160))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.reverseDegree(testData.s))
        }
    }
}
