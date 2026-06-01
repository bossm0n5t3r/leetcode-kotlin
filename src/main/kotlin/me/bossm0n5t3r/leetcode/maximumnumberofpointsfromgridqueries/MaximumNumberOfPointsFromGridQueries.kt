package me.bossm0n5t3r.leetcode.maximumnumberofpointsfromgridqueries

import java.util.PriorityQueue

class MaximumNumberOfPointsFromGridQueries {
    class Solution {
        fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
            val (m, n) = grid.size to grid.first().size
            val sortedQueries =
                queries.mapIndexed { index, query -> query to index }.sortedBy { it.first }
            val result = IntArray(queries.size)
            val visited = Array(m) { BooleanArray(n) }
            val direction = intArrayOf(0, 0, 1, -1).zip(intArrayOf(1, -1, 0, 0))

            val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.first - b.first }
            pq.offer(Triple(grid[0][0], 0, 0))
            visited[0][0] = true

            var totalPoints = 0

            for ((query, index) in sortedQueries) {
                while (pq.isNotEmpty() && pq.peek().first < query) {
                    val (_, r, c) = pq.poll()
                    totalPoints++

                    for ((dr, dc) in direction) {
                        val nr = r + dr
                        val nc = c + dc
                        if (nr in 0 until m && nc in 0 until n && visited[nr][nc].not()) {
                            pq.offer(Triple(grid[nr][nc], nr, nc))
                            visited[nr][nc] = true
                        }
                    }
                }
                result[index] = totalPoints
            }
            return result
        }
    }
}
