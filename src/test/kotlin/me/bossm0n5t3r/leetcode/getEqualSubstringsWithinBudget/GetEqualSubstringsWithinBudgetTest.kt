package me.bossm0n5t3r.leetcode.getEqualSubstringsWithinBudget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetEqualSubstringsWithinBudgetTest {
    private val sut = GetEqualSubstringsWithinBudget.Solution()

    private data class TestData(val s: String, val t: String, val maxCost: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("abcd", "bcdf", 3, 3),
                TestData("abcd", "cdef", 3, 1),
                TestData("abcd", "acde", 0, 1),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.equalSubstring(test.s, test.t, test.maxCost))
        }
    }
}
