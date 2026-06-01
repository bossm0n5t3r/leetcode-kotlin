package me.bossm0n5t3r.leetcode.wordSearch

class WordSearch {
    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            (board.indices).forEach { r ->
                (0 until board.first().size).forEach { c ->
                    if (board[r][c] == word.first()) {
                        if (dfs(r, c, board, word)) {
                            return true
                        }
                    }
                }
            }
            return false
        }

        private fun dfs(r: Int, c: Int, board: Array<CharArray>, word: String): Boolean {
            if (word.isEmpty()) return true
            val m = board.size
            val n = board.first().size
            if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.first()) return false
            val curChar = board[r][c]
            board[r][c] = '*'
            val subWord = word.substring(1)
            val result =
                (dfs(r - 1, c, board, subWord) ||
                    dfs(r + 1, c, board, subWord) ||
                    dfs(r, c - 1, board, subWord) ||
                    dfs(r, c + 1, board, subWord))
            board[r][c] = curChar
            return result
        }
    }
}
