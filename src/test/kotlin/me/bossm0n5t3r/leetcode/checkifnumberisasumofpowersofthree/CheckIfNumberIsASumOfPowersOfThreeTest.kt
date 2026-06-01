package me.bossm0n5t3r.leetcode.checkifnumberisasumofpowersofthree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfNumberIsASumOfPowersOfThreeTest {
    private val sut = CheckIfNumberIsASumOfPowersOfThree.Solution()

    private data class TestData(val n: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList = listOf(TestData(12, true), TestData(91, true), TestData(21, false))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.checkPowersOfThree(testData.n))
        }
    }
}
