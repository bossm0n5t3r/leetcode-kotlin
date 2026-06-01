package me.bossm0n5t3r.leetcode.minimumChangesToMakeAlternatingBinaryString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumChangesToMakeAlternatingBinaryStringTest {
    private val sut = MinimumChangesToMakeAlternatingBinaryString.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData("0100", 1), TestData("10", 0), TestData("1111", 2))

        tests.forEach { test -> assertEquals(test.result, sut.minOperations(test.s)) }
    }
}
