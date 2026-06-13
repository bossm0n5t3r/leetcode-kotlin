package me.bossm0n5t3r.leetcode.uniquePaths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsTest {
    private val uniquePaths = UniquePaths.Solution()

    data class UniquePathsTestData(val m: Int, val n: Int, val result: Int)

    @Test
    fun uniquePaths() {
        val tests =
            listOf(
                UniquePathsTestData(3, 7, 28),
                UniquePathsTestData(3, 2, 3),
                UniquePathsTestData(16, 16, 155117520),
            )
        tests.forEach { test ->
            assertEquals(test.result, uniquePaths.uniquePaths(test.m, test.n))
            assertEquals(test.result, uniquePaths.uniquePathsUsingDP(test.m, test.n))
        }
    }
}
