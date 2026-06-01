package me.bossm0n5t3r.leetcode.minimumBitFlipsToConvertNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumBitFlipsToConvertNumberTest {
    private val sut = MinimumBitFlipsToConvertNumber.Solution()

    private data class TestData(val start: Int, val goal: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(10, 7, 3), TestData(3, 4, 3))

        tests.forEach { test -> assertEquals(test.result, sut.minBitFlips(test.start, test.goal)) }
    }
}
