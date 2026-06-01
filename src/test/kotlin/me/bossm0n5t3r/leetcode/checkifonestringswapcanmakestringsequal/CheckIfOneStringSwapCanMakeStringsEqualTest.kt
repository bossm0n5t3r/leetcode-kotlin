package me.bossm0n5t3r.leetcode.checkifonestringswapcanmakestringsequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfOneStringSwapCanMakeStringsEqualTest {
    private val sut = CheckIfOneStringSwapCanMakeStringsEqual.Solution()

    private data class TestData(val s1: String, val s2: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("bank", "kanb", true),
                TestData("attack", "defend", false),
                TestData("kelb", "kelb", true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.areAlmostEqual(testData.s1, testData.s2))
        }
    }
}
