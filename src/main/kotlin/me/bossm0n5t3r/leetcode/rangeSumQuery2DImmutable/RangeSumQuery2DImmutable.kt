package me.bossm0n5t3r.leetcode.rangeSumQuery2DImmutable

class RangeSumQuery2DImmutable {
    class NumMatrix(matrix: Array<IntArray>) {
        private fun dp(matrix: Array<IntArray>): Array<IntArray> {
            val m = matrix.size
            val n = matrix.first().size
            val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
            (1..m).forEach { r -> dp[r][0] = matrix[r - 1][0] }
            (1..n).forEach { c -> dp[0][c] = matrix[0][c - 1] }
            (1..m).forEach { r ->
                (1..n).forEach { c ->
                    dp[r][c] =
                        (matrix[r - 1][c - 1] + dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1])
                }
            }
            return dp
        }

        private val dp = dp(matrix)

        fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
            dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1]
    }
}
