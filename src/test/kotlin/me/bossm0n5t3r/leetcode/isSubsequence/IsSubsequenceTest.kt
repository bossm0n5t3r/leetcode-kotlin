package me.bossm0n5t3r.leetcode.isSubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IsSubsequenceTest {
    private val sut = IsSubsequence.Solution()

    private data class TestData(val s: String, val t: String, val result: Boolean)

    @Test
    fun test() {
        val tests = listOf(TestData("abc", "ahbgdc", true), TestData("axc", "ahbgdc", false))

        tests.forEach { test -> assertEquals(sut.isSubsequence(test.s, test.t), test.result) }
    }
}
