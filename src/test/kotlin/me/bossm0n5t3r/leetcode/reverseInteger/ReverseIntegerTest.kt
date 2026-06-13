package me.bossm0n5t3r.leetcode.reverseInteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseIntegerTest {
    private val reverseInteger = ReverseInteger.Solution()

    data class ReverseIntegerTestData(val x: Int, val result: Int)

    @Test
    fun reverse() {
        val tests =
            listOf(
                ReverseIntegerTestData(123, 321),
                ReverseIntegerTestData(-123, -321),
                ReverseIntegerTestData(120, 21),
                ReverseIntegerTestData(0, 0),
                ReverseIntegerTestData(1534236469, 0),
            )
        tests.forEach { test -> assertEquals(test.result, reverseInteger.reverse(test.x)) }
    }
}
