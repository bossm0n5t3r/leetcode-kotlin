package me.bossm0n5t3r.leetcode.perfectSquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PerfectSquaresTest {
    private val sut = PerfectSquares.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(12, 3), TestData(13, 2))

        tests.forEach { test -> assertEquals(test.result, sut.numSquares(test.n)) }
    }
}
