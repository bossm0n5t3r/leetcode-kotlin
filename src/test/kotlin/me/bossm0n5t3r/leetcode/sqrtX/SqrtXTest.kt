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
            assertEquals(sqrtX.mySqrtFirst(test.x), test.result)
            assertEquals(sqrtX.mySqrtSecond(test.x), test.result)
        }
    }
}
