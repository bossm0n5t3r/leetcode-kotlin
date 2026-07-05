package me.bossm0n5t3r.leetcode.numberofpathswithmaxscore

class NumberOfPathsWithMaxScore {
    class Solution {
        fun pathsWithMaxScore(board: List<String>): IntArray {
            val modulo = 1_000_000_007
            val n = board.size
            val dp = Array(n) { IntArray(n) { -1 } }
            val count = Array(n) { IntArray(n) { 0 } }
            dp[0][0] = 0
            count[0][0] = 1
            for (r in 0 until n) {
                for (c in 0 until n) {
                    if (board[r][c] == 'X') {
                        dp[r][c] = -1
                    }
                }
            }

            val dr = intArrayOf(1, 0, 1)
            val dc = intArrayOf(0, 1, 1)

            for (r in 0 until n) {
                for (c in 0 until n) {
                    if (dp[r][c] == -1 || count[r][c] == 0) continue

                    for (k in 0 until 3) {
                        val nr = r + dr[k]
                        val nc = c + dc[k]
                        if (nr >= n || nc >= n) continue
                        if (board[nr][nc] == 'X') continue

                        val add =
                            when (board[nr][nc]) {
                                'S',
                                'E' -> 0
                                else -> board[nr][nc].digitToInt()
                            }
                        val newScore = dp[r][c] + add

                        when {
                            newScore > dp[nr][nc] -> {
                                dp[nr][nc] = newScore
                                count[nr][nc] = count[r][c]
                            }
                            newScore == dp[nr][nc] -> {
                                count[nr][nc] = (count[nr][nc] + count[r][c]) % modulo
                            }
                        }
                    }
                }
            }

            return if (dp[n - 1][n - 1] == -1) {
                intArrayOf(0, 0)
            } else {
                intArrayOf(dp[n - 1][n - 1], count[n - 1][n - 1])
            }
        }
    }
}
