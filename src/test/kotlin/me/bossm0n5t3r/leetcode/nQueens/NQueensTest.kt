package me.bossm0n5t3r.leetcode.nQueens

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NQueensTest {
    private val nQueens = NQueens.Solution()

    private data class NQueensTestData(val n: Int, val result: List<List<String>>)

    @Test
    fun solveNQueens() {
        val tests =
            listOf(
                NQueensTestData(
                    4,
                    listOf(
                        listOf(".Q..", "...Q", "Q...", "..Q."),
                        listOf("..Q.", "Q...", "...Q", ".Q.."),
                    ),
                ),
                NQueensTestData(1, listOf(listOf("Q"))),
            )
        tests.forEach { test ->
            nQueens.solveNQueens(test.n).also {
                assertThat(it).containsExactlyInAnyOrderElementsOf(test.result)
            }
        }
    }
}
