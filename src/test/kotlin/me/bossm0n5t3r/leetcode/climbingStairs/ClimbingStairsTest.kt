package me.bossm0n5t3r.leetcode.climbingStairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClimbingStairsTest {
    private val climbingStairs = ClimbingStairs.Solution()

    data class ClimbingStairsTestData(val n: Int, val result: Int)

    @Test
    fun climbStairs() {
        val tests = listOf(ClimbingStairsTestData(2, 2), ClimbingStairsTestData(3, 3))

        tests.forEach { test -> assertEquals(test.result, climbingStairs.climbStairs(test.n)) }
    }
}
