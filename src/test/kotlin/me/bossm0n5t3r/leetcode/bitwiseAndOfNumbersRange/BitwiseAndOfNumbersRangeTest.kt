package me.bossm0n5t3r.leetcode.bitwiseAndOfNumbersRange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseAndOfNumbersRangeTest {
    private val sut = BitwiseAndOfNumbersRange.Solution()

    private data class TestData(val left: Int, val right: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(5, 7, 4), TestData(0, 0, 0), TestData(1, 2147483647, 0))

        tests.forEach { test ->
            assertEquals(test.result, sut.rangeBitwiseAnd(test.left, test.right))
        }
    }
}
