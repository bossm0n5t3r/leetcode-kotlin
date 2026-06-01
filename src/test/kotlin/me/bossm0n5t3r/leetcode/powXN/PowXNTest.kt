package me.bossm0n5t3r.leetcode.powXN

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PowXNTest {
    private val sut = PowXN.Solution()

    private data class TestData(val x: Double, val n: Int, val result: Double)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(2.00000, 10, 1024.00000),
                TestData(2.10000, 3, 9.261000000000001),
                TestData(2.00000, -2, 0.25000),
                TestData(0.00001, 2147483647, 0.0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.myPow(test.x, test.n)) }
    }
}
