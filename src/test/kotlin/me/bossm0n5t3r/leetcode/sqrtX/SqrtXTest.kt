package me.bossm0n5t3r.leetcode.sqrtX

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SqrtXTest {
    private val sqrtX = SqrtX.Solution()

    data class SqrtXTestData(val x: Int, val result: Int)

    @Test
    fun mySqrt() {
        val tests =
            listOf(SqrtXTestData(4, 2), SqrtXTestData(8, 2), SqrtXTestData(2147395600, 46340))
        tests.forEach { test ->
            assertEquals(test.result, sqrtX.mySqrtFirst(test.x))
            assertEquals(test.result, sqrtX.mySqrtSecond(test.x))
        }
    }
}
