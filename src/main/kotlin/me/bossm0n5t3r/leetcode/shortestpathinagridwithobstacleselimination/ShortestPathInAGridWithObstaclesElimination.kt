package me.bossm0n5t3r.leetcode.shortestpathinagridwithobstacleselimination

import java.util.PriorityQueue

class ShortestPathInAGridWithObstaclesElimination {
    class Solution {
        private data class Move(val r: Int, val c: Int, val broken: Int, val step: Int) {
            fun next(nr: Int, nc: Int, obstacle: Int): Move =
                Move(nr, nc, broken + obstacle, step + 1)
        }

        fun shortestPath(grid: Array<IntArray>, k: Int): Int {
            val (m, n) = grid.size to grid.first().size
            val diff = intArrayOf(0, 0, 1, -1).zip(intArrayOf(1, -1, 0, 0))
            val pq =
                PriorityQueue<Move>(compareBy { it.step }).apply {
                    offer(Move(0, 0, grid[0][0], 0))
                }
            val visited = mutableSetOf(Triple(0, 0, grid[0][0]))
            while (pq.isNotEmpty()) {
                val cur = pq.poll()
                val (r, c, broken, step) = cur
                if (r == m - 1 && c == n - 1) return step
                for ((dr, dc) in diff) {
                    val nr = r + dr
                    val nc = c + dc
                    if (
                        nr in 0 until m &&
                            nc in 0 until n &&
                            visited.contains(Triple(nr, nc, broken + grid[nr][nc])).not()
                    ) {
                        if (broken + grid[nr][nc] > k) continue
                        visited.add(Triple(nr, nc, broken + grid[nr][nc]))
                        pq.offer(cur.next(nr, nc, grid[nr][nc]))
                    }
                }
            }
            return -1
        }
    }
}
