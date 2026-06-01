package me.bossm0n5t3r.leetcode.maximumNumberOfFishInAGrid

import java.util.LinkedList
import java.util.Queue

class MaximumNumberOfFishInAGrid {
    class Solution {
        private val dr = intArrayOf(0, 0, 1, -1)
        private val dc = intArrayOf(1, -1, 0, 0)

        fun findMaxFish(grid: Array<IntArray>): Int {
            var result = 0
            val m = grid.size
            val n = grid[0].size
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] > 0) {
                        result = maxOf(result, bfs(grid, m, n, r, c))
                    }
                }
            }
            return result
        }

        private fun bfs(grid: Array<IntArray>, m: Int, n: Int, r: Int, c: Int): Int {
            val queue =
                LinkedList<Pair<Int, Int>>().apply { this.offer(r to c) } as Queue<Pair<Int, Int>>
            var result = 0
            while (queue.isNotEmpty()) {
                val (curR, curC) = queue.poll()
                result += grid[curR][curC]
                grid[curR][curC] = 0
                for (i in 0 until 4) {
                    val nr = curR + dr[i]
                    val nc = curC + dc[i]
                    if (nr in 0 until m && nc in 0 until n && grid[nr][nc] > 0) {
                        queue.offer(nr to nc)
                    }
                }
            }
            return result
        }
    }
}
