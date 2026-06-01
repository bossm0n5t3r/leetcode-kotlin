package me.bossm0n5t3r.leetcode.strangePrinter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrangePrinterTest {
    private val sut = StrangePrinter.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData("aaabbb", 2), TestData("aba", 2))

        tests.forEach { test -> assertEquals(test.result, sut.strangePrinter(test.s)) }
    }
}
