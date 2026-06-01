package me.bossm0n5t3r.leetcode.pathWithMaximumGold

class PathWithMaximumGold {
    class Solution {
        fun getMaximumGold(grid: Array<IntArray>): Int {
            var answer = 0
            val (m, n) = grid.size to grid[0].size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] != 0) {
                        val visited =
                            Array(m) { BooleanArray(n) { false } }.apply { this[r][c] = true }
                        val resultArray = IntArray(1) { 0 }
                        dfs(grid, visited, m, n, r, c, grid[r][c], resultArray)
                        if (resultArray[0] > answer) {
                            answer = resultArray[0]
                        }
                    }
                }
            }
            return answer
        }

        private fun dfs(
            grid: Array<IntArray>,
            visited: Array<BooleanArray>,
            m: Int,
            n: Int,
            r: Int,
            c: Int,
            curResult: Int,
            resultArray: IntArray,
        ) {
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)

            if (curResult > resultArray[0]) {
                resultArray[0] = curResult
            }

            for (i in 0 until 4) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (
                    nr in 0 until m && nc in 0 until n && grid[nr][nc] != 0 && visited[nr][nc].not()
                ) {
                    visited[nr][nc] = true
                    dfs(grid, visited, m, n, nr, nc, curResult + grid[nr][nc], resultArray)
                    visited[nr][nc] = false
                }
            }
        }
    }
}
