package me.bossm0n5t3r.leetcode.sudokuSolver

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SudokuSolverTest {
    private val sudokuSolver = SudokuSolver.Solution()

    private data class SudokuSolverTestData(
        val board: Array<CharArray>,
        val result: Array<CharArray>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SudokuSolverTestData

            if (!board.contentDeepEquals(other.board)) return false

            return true
        }

        override fun hashCode(): Int = board.contentDeepHashCode()
    }

    private fun String.toSudokuBoard(): Array<CharArray> {
        val length = this.length
        val content = this.substring(2, length - 2)
        return content
            .replace("\n", "")
            .split("],[")
            .map { row ->
                val rowLength = row.length
                row.substring(1, rowLength - 1).split("\",\"").map { it.single() }.toCharArray()
            }
            .toTypedArray()
    }

    @Test
    fun solveSudoku() {
        val tests =
            listOf(
                SudokuSolverTestData(
                    board =
                        """
                        [["5","3",".",".","7",".",".",".","."],
                        ["6",".",".","1","9","5",".",".","."],
                        [".","9","8",".",".",".",".","6","."],
                        ["8",".",".",".","6",".",".",".","3"],
                        ["4",".",".","8",".","3",".",".","1"],
                        ["7",".",".",".","2",".",".",".","6"],
                        [".","6",".",".",".",".","2","8","."],
                        [".",".",".","4","1","9",".",".","5"],
                        [".",".",".",".","8",".",".","7","9"]]
                        """
                            .trimIndent()
                            .toSudokuBoard(),
                    result =
                        """
                        [["5","3","4","6","7","8","9","1","2"],
                        ["6","7","2","1","9","5","3","4","8"],
                        ["1","9","8","3","4","2","5","6","7"],
                        ["8","5","9","7","6","1","4","2","3"],
                        ["4","2","6","8","5","3","7","9","1"],
                        ["7","1","3","9","2","4","8","5","6"],
                        ["9","6","1","5","3","7","2","8","4"],
                        ["2","8","7","4","1","9","6","3","5"],
                        ["3","4","5","2","8","6","1","7","9"]]
                        """
                            .trimIndent()
                            .toSudokuBoard(),
                ),
                SudokuSolverTestData(
                    board =
                        """
                        [[".",".","9","7","4","8",".",".","."],
                        ["7",".",".",".",".",".",".",".","."],
                        [".","2",".","1",".","9",".",".","."],
                        [".",".","7",".",".",".","2","4","."],
                        [".","6","4",".","1",".","5","9","."],
                        [".","9","8",".",".",".","3",".","."],
                        [".",".",".","8",".","3",".","2","."],
                        [".",".",".",".",".",".",".",".","6"],
                        [".",".",".","2","7","5","9",".","."]]
                        """
                            .trimIndent()
                            .toSudokuBoard(),
                    result =
                        """
                        [["5","1","9","7","4","8","6","3","2"],
                        ["7","8","3","6","5","2","4","1","9"],
                        ["4","2","6","1","3","9","8","7","5"],
                        ["3","5","7","9","8","6","2","4","1"],
                        ["2","6","4","3","1","7","5","9","8"],
                        ["1","9","8","5","2","4","3","6","7"],
                        ["9","7","5","8","6","3","1","2","4"],
                        ["8","3","2","4","9","1","7","5","6"],
                        ["6","4","1","2","7","5","9","8","3"]]
                        """
                            .trimIndent()
                            .toSudokuBoard(),
                ),
            )
        tests.forEach { test ->
            sudokuSolver.solveSudoku(test.board)
            assertThat(test.board).isDeepEqualTo(test.result)
        }
    }

    @Test
    fun isValid() {
        val validResult =
            """
            [["5","3","4","6","7","8","9","1","2"],
            ["6","7","2","1","9","5","3","4","8"],
            ["1","9","8","3","4","2","5","6","7"],
            ["8","5","9","7","6","1","4","2","3"],
            ["4","2","6","8","5","3","7","9","1"],
            ["7","1","3","9","2","4","8","5","6"],
            ["9","6","1","5","3","7","2","8","4"],
            ["2","8","7","4","1","9","6","3","5"],
            ["3","4","5","2","8","6","1","7","9"]]
            """
                .trimIndent()
                .toSudokuBoard()
        assertTrue(sudokuSolver.isValid(validResult))
        val invalidResult =
            """
            [["5","3",".",".","7",".",".",".","."],
            ["6",".",".","1","9","5",".",".","."],
            [".","9","8",".",".",".",".","6","."],
            ["8",".",".",".","6",".",".",".","3"],
            ["4",".",".","8",".","3",".",".","1"],
            ["7",".",".",".","2",".",".",".","6"],
            [".","6",".",".",".",".","2","8","."],
            [".",".",".","4","1","9",".",".","5"],
            [".",".",".",".","8",".",".","7","9"]]
            """
                .trimIndent()
                .toSudokuBoard()
        assertFalse(sudokuSolver.isValid(invalidResult))
    }
}
