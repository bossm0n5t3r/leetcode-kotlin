package me.bossm0n5t3r.leetcode.minimumFlipsToMakeAOrBEqualToC

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFlipsToMakeAOrBEqualToCTest {
    private val sut = MinimumFlipsToMakeAOrBEqualToC.Solution()

    private data class TestData(val a: Int, val b: Int, val c: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(a = 2, b = 6, c = 5, result = 3),
                TestData(a = 4, b = 2, c = 7, result = 1),
                TestData(a = 1, b = 2, c = 3, result = 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minFlips(test.a, test.b, test.c)) }
    }
}
