package me.bossm0n5t3r.leetcode.nQueens2

class NQueens2 {
    class Solution {
        fun totalNQueens(n: Int): Int {
            val result = Result()
            val board = Array(n) { CharArray(n) { '.' } }
            dfs(n, board, 0, result)
            return result.result
        }

        private data class Result(var result: Int = 0) {
            fun add() {
                this.result++
            }
        }

        private fun dfs(n: Int, board: Array<CharArray>, row: Int, result: Result) {
            if (row == n) {
                result.add()
                return
            }
            (0 until n).forEach { col ->
                if (isSafe(n, board, row, col)) {
                    board[row][col] = 'Q'
                    dfs(n, board, row + 1, result)
                    board[row][col] = '.'
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
