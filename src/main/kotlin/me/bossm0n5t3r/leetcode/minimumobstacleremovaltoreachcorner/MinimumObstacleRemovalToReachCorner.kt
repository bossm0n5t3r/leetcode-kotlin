package me.bossm0n5t3r.leetcode.minimumobstacleremovaltoreachcorner

import java.util.PriorityQueue

class MinimumObstacleRemovalToReachCorner {
    class Solution {
        fun minimumObstacles(grid: Array<IntArray>): Int {
            val (m, n) = grid.size to grid.first().size
            val diff = intArrayOf(0, 0, 1, -1).zip(intArrayOf(1, -1, 0, 0))
            val pq =
                PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third }).apply {
                    offer(Triple(0, 0, grid[0][0]))
                }
            val visited = mutableSetOf(0 to 0)
            while (pq.isNotEmpty()) {
                val (r, c, broken) = pq.poll()
                if (r == m - 1 && c == n - 1) return broken
                for ((dr, dc) in diff) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr in 0 until m && nc in 0 until n && visited.contains(nr to nc).not()) {
                        visited.add(nr to nc)
                        pq.offer(Triple(nr, nc, broken + grid[nr][nc]))
                    }
                }
            }
            return -1
        }
    }
}
