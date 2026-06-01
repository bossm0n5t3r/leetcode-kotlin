package me.bossm0n5t3r.leetcode.maximumOddBinaryNumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumOddBinaryNumberTest {
    private val sut = MaximumOddBinaryNumber.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val tests = listOf(TestData("010", "001"), TestData("0101", "1001"))

        tests.forEach { test -> assertEquals(test.result, sut.maximumOddBinaryNumber(test.s)) }
    }
}
