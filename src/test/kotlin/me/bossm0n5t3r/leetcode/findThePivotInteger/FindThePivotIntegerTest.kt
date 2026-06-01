package me.bossm0n5t3r.leetcode.findThePivotInteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindThePivotIntegerTest {
    private val sut = FindThePivotInteger.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(8, 6), TestData(1, 1), TestData(4, -1))

        tests.forEach { test -> assertEquals(test.result, sut.pivotInteger(test.n)) }
    }
}
