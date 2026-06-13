package me.bossm0n5t3r.leetcode.nQueens2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NQueens2Test {
    private val nQueens2 = NQueens2.Solution()

    private data class NQueens2TestData(val n: Int, val result: Int)

    @Test
    fun totalNQueens() {
        val tests = listOf(NQueens2TestData(4, 2), NQueens2TestData(1, 1))
        tests.forEach { test ->
            nQueens2.totalNQueens(test.n).also { assertEquals(test.result, it) }
        }
    }
}
