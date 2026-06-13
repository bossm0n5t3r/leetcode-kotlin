package me.bossm0n5t3r.leetcode.divideTwoIntegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DivideTwoIntegersTest {
    private val divideTwoIntegers = DivideTwoIntegers.Solution()

    private data class DivideTwoIntegersTestData(
        val dividend: Int,
        val divisor: Int,
        val result: Int,
    )

    @Test
    fun divide() {
        val tests =
            listOf(
                DivideTwoIntegersTestData(10, 3, 3),
                DivideTwoIntegersTestData(7, -3, -2),
                DivideTwoIntegersTestData(0, 1, 0),
                DivideTwoIntegersTestData(1, -1, -1),
                DivideTwoIntegersTestData(-2147483648, -1, 2147483647),
                DivideTwoIntegersTestData(-2147483648, 1, -2147483648),
                DivideTwoIntegersTestData(2147483647, 3, 715827882),
                DivideTwoIntegersTestData(-2147483648, -3, 715827882),
            )
        tests.forEach { test ->
            val result = divideTwoIntegers.divide(test.dividend, test.divisor)
            assertEquals(test.result, result)
        }
    }

    @Test
    fun shlTest() {
        assertEquals((1 shl 31) - 1, Int.MAX_VALUE)
    }
}
