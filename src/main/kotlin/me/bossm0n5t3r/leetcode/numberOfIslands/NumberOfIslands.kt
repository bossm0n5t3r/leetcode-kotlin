package me.bossm0n5t3r.leetcode.numberOfIslands

import java.util.LinkedList
import java.util.Queue

class NumberOfIslands {
    class Solution {
        fun numIslands(grid: Array<CharArray>): Int {
            var islands = 0
            val m = grid.size
            val n = grid[0].size
            val visited = Array(m) { BooleanArray(n) }
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == '0' || visited[r][c]) continue
                    islands++
                    bfs(grid, visited, m, n, r, c)
                }
            }
            return islands
        }

        private fun bfs(
            grid: Array<CharArray>,
            visited: Array<BooleanArray>,
            m: Int,
            n: Int,
            curR: Int,
            curC: Int,
        ) {
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)
            val queue: Queue<Pair<Int, Int>> =
                LinkedList<Pair<Int, Int>>().apply { this.offer(curR to curC) }
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
                            visited[nr][nc].not()
                    ) {
                        visited[nr][nc] = true
                        queue.offer(nr to nc)
                    }
                }
            }
        }
    }
}
