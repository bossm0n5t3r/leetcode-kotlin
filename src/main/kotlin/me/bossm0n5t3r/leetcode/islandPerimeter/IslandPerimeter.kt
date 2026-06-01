package me.bossm0n5t3r.leetcode.islandPerimeter

import java.util.LinkedList
import java.util.Queue

class IslandPerimeter {
    class Solution {
        fun islandPerimeter(grid: Array<IntArray>): Int {
            val (m, n) = grid.size to grid[0].size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == 1) return bfs(grid, m, n, r, c)
                }
            }
            return -1
        }

        private fun bfs(grid: Array<IntArray>, m: Int, n: Int, curR: Int, curC: Int): Int {
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)
            val visited = Array(m) { BooleanArray(n) { false } }
            val queue: Queue<Pair<Int, Int>> =
                LinkedList<Pair<Int, Int>>().apply { this.offer(curR to curC) }
            var count = 0
            while (queue.isNotEmpty()) {
                val (r, c) = queue.poll()
                visited[r][c] = true
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if ((nr in 0 until m && nc in 0 until n).not() || grid[nr][nc] == 0) {
                        count++
                        continue
                    }
                    if (visited[nr][nc].not()) {
                        visited[nr][nc] = true
                        queue.offer(nr to nc)
                    }
                }
            }
            return count
        }
    }
}
