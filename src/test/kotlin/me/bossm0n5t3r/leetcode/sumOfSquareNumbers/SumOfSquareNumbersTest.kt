package me.bossm0n5t3r.leetcode.sumOfSquareNumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSquareNumbersTest {
    private val sut = SumOfSquareNumbers.Solution()

    private data class TestData(val c: Int, val result: Boolean)

    @Test
    fun test() {
        val tests = listOf(TestData(5, true), TestData(3, false))

        tests.forEach { test -> assertEquals(test.result, sut.judgeSquareSum(test.c)) }
    }
}
