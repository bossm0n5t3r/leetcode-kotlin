package me.bossm0n5t3r.leetcode.minimumDeletionsToMakeStringBalanced

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeStringBalancedTest {
    private val sut = MinimumDeletionsToMakeStringBalanced.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData("aababbab", 2), TestData("bbaaaaabb", 2))

        tests.forEach { test -> assertEquals(test.result, sut.minimumDeletions(test.s)) }
    }
}
