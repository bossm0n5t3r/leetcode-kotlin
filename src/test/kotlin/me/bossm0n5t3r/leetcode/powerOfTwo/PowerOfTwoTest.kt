package me.bossm0n5t3r.leetcode.powerOfTwo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PowerOfTwoTest {
    private val sut = PowerOfTwo.Solution()

    private data class TestData(val n: Int, val result: Boolean)

    @Test
    fun test() {
        val tests = listOf(TestData(1, true), TestData(16, true), TestData(3, false))

        tests.forEach { test -> assertEquals(test.result, sut.isPowerOfTwo(test.n)) }
    }
}
