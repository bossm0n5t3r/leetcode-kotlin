package me.bossm0n5t3r.leetcode.longestIncreasingPathInAMatrix

import kotlin.math.max

class LongestIncreasingPathInAMatrix {
    class Solution {
        fun longestIncreasingPath(matrix: Array<IntArray>): Int {
            var result = 0
            val m = matrix.size
            val n = matrix.first().size
            val cache = Array(m) { IntArray(n) { 0 } }
            (0 until m).forEach { r ->
                (0 until n).forEach { c ->
                    val length = dfs(matrix, m, n, r, c, cache)
                    result = max(result, length)
                }
            }
            return result
        }

        private fun dfs(
            matrix: Array<IntArray>,
            m: Int,
            n: Int,
            r: Int,
            c: Int,
            cache: Array<IntArray>,
        ): Int {
            if (cache[r][c] != 0) return cache[r][c]
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)

            var max = 1
            (0 until 4).forEach { i ->
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (
                    (0 until m).contains(nr) &&
                        (0 until n).contains(nc) &&
                        matrix[r][c] < matrix[nr][nc]
                ) {
                    val len = 1 + dfs(matrix, m, n, nr, nc, cache)
                    max = max(max, len)
                }
            }
            cache[r][c] = max
            return max
        }
    }
}
