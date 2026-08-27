package me.bossm0n5t3r.leetcode.numberofislands

import java.util.LinkedList

class NumberOfIslands {
    class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
            val (m, n) = grid.size to grid.first().size
            val visited = Array(m) { BooleanArray(n) }
            var result = 0
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == '0') continue
                    if (visited[r][c]) continue
                    bfs(grid, m, n, visited, r, c)
                    result++
                }
            }
            return result
        }

        private val dr = intArrayOf(0, 0, 1, -1)
        private val dc = intArrayOf(1, -1, 0, 0)

        private fun bfs(
            grid: Array<CharArray>,
            m: Int,
            n: Int,
            visited: Array<BooleanArray>,
            curR: Int,
            curC: Int,
        ) {
            val queue = LinkedList<Pair<Int, Int>>()
            queue.offer(curR to curC)
            while (queue.isNotEmpty()) {
                val (r, c) = queue.poll()
                visited[r][c] = true
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (
                        nr in 0 until m &&
                            nc in 0 until n &&
                            grid[nr][nc] == '1' &&
                            !visited[nr][nc]
                    ) {
                        visited[nr][nc] = true
                        queue.offer(nr to nc)
                    }
                }
            }
        }
    }
}
