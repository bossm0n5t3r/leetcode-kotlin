package me.bossm0n5t3r.leetcode.nQueens

class NQueens {
    class Solution {
        fun solveNQueens(n: Int): List<List<String>> {
            val result = Result()
            val board = Array(n) { CharArray(n) { '.' } }
            dfs(n, board, 0, result)
            return result.result.map { it.toList() }
        }

        private data class Result(val result: MutableSet<List<String>> = mutableSetOf())

        private fun dfs(n: Int, board: Array<CharArray>, row: Int, result: Result) {
            if (row == n) {
                result.result.add(board.map { it.joinToString("") })
                return
            }
            (0 until n).forEach { c ->
                if (isSafe(n, board, row, c)) {
                    board[row][c] = 'Q'
                    dfs(n, board, row + 1, result)
                    board[row][c] = '.'
                }
            }
        }

        private fun isSafe(n: Int, board: Array<CharArray>, row: Int, col: Int): Boolean {
            (0 until n).forEach { i ->
                if (board[i][col] == 'Q') return false
                if (row >= i && col >= i && board[row - i][col - i] == 'Q') return false
                if (row >= i && col + i < n && board[row - i][col + i] == 'Q') return false
            }
            return true
        }
    }
}
