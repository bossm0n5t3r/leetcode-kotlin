package me.bossm0n5t3r.leetcode.numberofislands

class NumberOfIslands {
    class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
            val (m, n) = grid.size to grid.first().size
            var result = 0
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == '0') continue
                    bfs(grid, m, n, r, c)
                    result++
                }
            }
            return result
        }

        private val dr = intArrayOf(0, 0, 1, -1)
        private val dc = intArrayOf(1, -1, 0, 0)

        private fun bfs(grid: Array<CharArray>, m: Int, n: Int, curR: Int, curC: Int) {
            val queue = ArrayDeque<Pair<Int, Int>>()
            grid[curR][curC] = '0'
            queue.addLast(curR to curC)

            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeFirst()
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == '1') {
                        grid[nr][nc] = '0'
                        queue.addLast(nr to nc)
                    }
                }
            }
        }
    }
}
