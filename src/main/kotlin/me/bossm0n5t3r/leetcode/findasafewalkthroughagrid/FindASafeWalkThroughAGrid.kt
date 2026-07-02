package me.bossm0n5t3r.leetcode.findasafewalkthroughagrid

import java.util.PriorityQueue

class FindASafeWalkThroughAGrid {
    class Solution {
        fun findSafeWalk(grid: List<List<Int>>, health: Int): Boolean {
            val (m, n) = grid.size to grid.first().size
            val pq = PriorityQueue<Triple<Int, Int, Int>>(compareByDescending { it.third })
            val visited = Array(m) { BooleanArray(n) { false } }
            pq.offer(Triple(0, 0, health - grid[0][0]))
            visited[0][0] = true
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)
            while (pq.isNotEmpty()) {
                val (r, c, curHealth) = pq.poll()
                if (r == m - 1 && c == n - 1 && curHealth >= 1) return true
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (nr in 0 until m && nc in 0 until n && !visited[nr][nc]) {
                        val nextHealth = curHealth - grid[nr][nc]
                        if (nextHealth == 0) continue
                        visited[nr][nc] = true
                        pq.offer(Triple(nr, nc, nextHealth))
                    }
                }
            }
            return false
        }
    }
}
