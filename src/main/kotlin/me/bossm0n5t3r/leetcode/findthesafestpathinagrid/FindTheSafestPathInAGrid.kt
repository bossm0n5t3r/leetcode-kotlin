package me.bossm0n5t3r.leetcode.findthesafestpathinagrid

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

class FindTheSafestPathInAGrid {
    class Solution {
        private companion object {
            val DR = intArrayOf(0, 0, 1, -1)
            val DC = intArrayOf(1, -1, 0, 0)
        }

        fun maximumSafenessFactor(grid: List<List<Int>>): Int {
            val (m, n) = grid.size to grid.first().size
            val dist = Array(m) { IntArray(n) { -1 } }
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid[r][c] == 1) {
                        dist[r][c] = 0
                        queue.offer(r to c)
                    }
                }
            }
            bfs(dist, m, n, queue)
            return dijkstra(dist, m, n)
        }

        private fun bfs(dist: Array<IntArray>, m: Int, n: Int, queue: Queue<Pair<Int, Int>>) {
            while (queue.isNotEmpty()) {
                val (r, c) = queue.poll()
                for (i in 0 until 4) {
                    val nr = r + DR[i]
                    val nc = c + DC[i]
                    if (nr in 0 until m && nc in 0 until n && dist[nr][nc] == -1) {
                        dist[nr][nc] = dist[r][c] + 1
                        queue.offer(nr to nc)
                    }
                }
            }
        }

        private fun dijkstra(dist: Array<IntArray>, m: Int, n: Int): Int {
            val pq = PriorityQueue<Triple<Int, Int, Int>>(compareByDescending { it.first })
            val visited = Array(m) { BooleanArray(n) }
            pq.offer(Triple(dist[0][0], 0, 0))
            visited[0][0] = true

            while (pq.isNotEmpty()) {
                val (score, r, c) = pq.poll()
                if (r == m - 1 && c == n - 1) return score
                for (i in 0 until 4) {
                    val nr = r + DR[i]
                    val nc = c + DC[i]
                    if (nr in 0 until m && nc in 0 until n && !visited[nr][nc]) {
                        visited[nr][nc] = true
                        pq.offer(Triple(minOf(score, dist[nr][nc]), nr, nc))
                    }
                }
            }
            return 0
        }
    }
}
