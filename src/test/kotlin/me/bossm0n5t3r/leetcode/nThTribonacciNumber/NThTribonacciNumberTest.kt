package me.bossm0n5t3r.leetcode.nThTribonacciNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NThTribonacciNumberTest {
    private val sut = NThTribonacciNumber.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(4, 4), TestData(25, 1389537))

        tests.forEach { test -> assertEquals(test.result, sut.tribonacci(test.n)) }
    }
}
