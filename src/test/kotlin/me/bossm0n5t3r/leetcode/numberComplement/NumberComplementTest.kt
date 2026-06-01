package me.bossm0n5t3r.leetcode.numberComplement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberComplementTest {
    private val sut = NumberComplement.Solution()

    private data class TestData(val num: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(5, 2), TestData(1, 0))

        tests.forEach { test -> assertEquals(test.result, sut.findComplement(test.num)) }
    }
}
