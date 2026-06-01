package me.bossm0n5t3r.leetcode.powerOfThree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PowerOfThreeTest {
    private val powerOfThree = PowerOfThree.Solution()

    data class PowerOfThreeTestData(val n: Int, val result: Boolean)

    @Test
    fun isPowerOfThree() {
        val tests =
            listOf(
                PowerOfThreeTestData(27, true),
                PowerOfThreeTestData(0, false),
                PowerOfThreeTestData(9, true),
                PowerOfThreeTestData(45, false),
                PowerOfThreeTestData(-3, false),
            )
        tests.forEach { test ->
            assertEquals(powerOfThree.isPowerOfThree(test.n), test.result)
            assertEquals(powerOfThree.isPowerOfThreeUsingMathematics(test.n), test.result)
        }
    }
}
