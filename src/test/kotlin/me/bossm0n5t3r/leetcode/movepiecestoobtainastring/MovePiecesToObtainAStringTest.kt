package me.bossm0n5t3r.leetcode.movepiecestoobtainastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovePiecesToObtainAStringTest {
    private val sut = MovePiecesToObtainAString.Solution()

    private data class TestData(val start: String, val target: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("_L__R__R_", "L______RR", true),
                TestData("R_L_", "__LR", false),
                TestData("_R", "R_", false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canChange(testData.start, testData.target))
        }
    }
}
