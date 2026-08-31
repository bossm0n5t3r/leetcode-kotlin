package me.bossm0n5t3r.leetcode.wordsearch

class WordSearch {
    class Solution {
        fun exist(board: Array<CharArray>, word: String): Boolean {
            val (m, n) = board.size to board.first().size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (dfs(board, m, n, word, r, c)) return true
                }
            }
            return false
        }

        private fun dfs(
            board: Array<CharArray>,
            m: Int,
            n: Int,
            word: String,
            r: Int,
            c: Int,
        ): Boolean {
            if (word.isEmpty()) return true
            if (r !in 0 until m || c !in 0 until n || board[r][c] != word.first()) return false
            val curChar = board[r][c]
            board[r][c] = '*'
            val subWord = word.substring(1)
            val result =
                (dfs(board, m, n, subWord, r - 1, c) ||
                    dfs(board, m, n, subWord, r + 1, c) ||
                    dfs(board, m, n, subWord, r, c - 1) ||
                    dfs(board, m, n, subWord, r, c + 1))
            board[r][c] = curChar
            return result
        }
    }
}
