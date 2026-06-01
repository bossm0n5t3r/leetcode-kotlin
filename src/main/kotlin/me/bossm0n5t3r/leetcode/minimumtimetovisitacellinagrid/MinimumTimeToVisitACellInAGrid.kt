package me.bossm0n5t3r.leetcode.minimumtimetovisitacellinagrid

import java.util.PriorityQueue

class MinimumTimeToVisitACellInAGrid {
    class Solution {
        fun minimumTime(grid: Array<IntArray>): Int {
            if (minOf(grid[0][1], grid[1][0]) > 1) return -1
            val (m, n) = grid.size to grid[0].size
            val dirs =
                arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
            val minHeap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
            minHeap.offer(Triple(0, 0, 0))
            val visit = mutableSetOf<String>()
            while (minHeap.isNotEmpty()) {
                val (t, r, c) = minHeap.poll()
                if (r == m - 1 && c == n - 1) return t
                for ((dr, dc) in dirs) {
                    val nr = r + dr
                    val nc = c + dc
                    val key = "$nr,$nc"
                    if (nr < 0 || nc < 0 || nr == m || nc == n || visit.contains(key)) {
                        continue
                    }
                    val abs = if (grid[nr][nc] > t) grid[nr][nc] - t else t - grid[nr][nc]
                    val wait = if (abs % 2 == 0) 1 else 0
                    val nTime = maxOf((grid[nr][nc] + wait), (t + 1))
                    minHeap.offer(Triple(nTime, nr, nc))
                    visit.add(key)
                }
            }
            return -1
        }
    }
}
