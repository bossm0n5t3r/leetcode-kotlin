package me.bossm0n5t3r.leetcode.sudokuSolver

class SudokuSolverFaster {
    class Solution {
        fun solveSudoku(board: Array<CharArray>) {
            solve(board, 0, 0)
        }

        private fun solve(board: Array<CharArray>, row: Int, column: Int): Boolean {
            var col = column
            for (r in row until 9) {
                for (c in col until 9) {
                    if (board[r][c] != '.') continue

                    for (char in '1'..'9') {
                        if (isValid(board, r, c, char)) {
                            board[r][c] = char
                            if (solve(board, r, c + 1)) {
                                return true
                            }
                            board[r][c] = '.'
                        }
                    }
                    return false
                }
                col = 0
            }
            return true
        }

        private fun isValid(board: Array<CharArray>, row: Int, column: Int, c: Char): Boolean {
            val blockRow = (row / 3) * 3
            val blockColumn = (column / 3) * 3

            for (i in 0 until 9) {
                if (
                    board[i][column] == c ||
                        board[row][i] == c ||
                        board[blockRow + (i / 3)][blockColumn + (i % 3)] == c
                ) {
                    return false
                }
            }
            return true
        }
    }
}
