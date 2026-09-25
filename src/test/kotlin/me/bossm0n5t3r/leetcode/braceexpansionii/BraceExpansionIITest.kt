package me.bossm0n5t3r.leetcode.braceexpansionii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BraceExpansionIITest {
    private val sut = BraceExpansionII.Solution()

    private class TestData(val expression: String, val result: List<String>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("{a,b}{c,{d,e}}", listOf("ac", "ad", "ae", "bc", "bd", "be")),
                TestData("{{a,z},a{b,c},{ab,z}}", listOf("a", "ab", "ac", "z")),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.braceExpansionII(testData.expression))
        }
    }
}
