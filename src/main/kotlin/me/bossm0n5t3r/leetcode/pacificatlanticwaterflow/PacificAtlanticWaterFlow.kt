package me.bossm0n5t3r.leetcode.pacificatlanticwaterflow

class PacificAtlanticWaterFlow {
    class Solution {
        fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
            val (m, n) = heights.size to heights.first().size

            val pacific = ArrayDeque<Pair<Int, Int>>()
            pacific.addLast(0 to 0)
            for (r in 1 until m) pacific.addLast(r to 0)
            for (c in 1 until n) pacific.addLast(0 to c)

            val atlantic = ArrayDeque<Pair<Int, Int>>()
            atlantic.addLast(m - 1 to n - 1)
            for (r in 0 until m - 1) atlantic.addLast(r to n - 1)
            for (c in 0 until n - 1) atlantic.addLast(m - 1 to c)

            val visited = Array(m) { Array(n) { BooleanArray(2) } }

            bfs(heights, m, n, pacific, visited, 0)
            bfs(heights, m, n, atlantic, visited, 1)

            val result = mutableListOf<List<Int>>()

            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (visited[r][c].all { it }) {
                        result += listOf(r, c)
                    }
                }
            }

            return result
        }

        private val dr = intArrayOf(0, 0, 1, -1)
        private val dc = intArrayOf(1, -1, 0, 0)

        private fun bfs(
            heights: Array<IntArray>,
            m: Int,
            n: Int,
            queue: ArrayDeque<Pair<Int, Int>>,
            visited: Array<Array<BooleanArray>>,
            updateIndex: Int,
        ) {
            while (queue.isNotEmpty()) {
                val (r, c) = queue.removeFirstOrNull() ?: break
                visited[r][c][updateIndex] = true
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (
                        nr in 0 until m &&
                            nc in 0 until n &&
                            heights[r][c] <= heights[nr][nc] &&
                            !visited[nr][nc][updateIndex]
                    ) {
                        visited[nr][nc][updateIndex] = true
                        queue.addLast(nr to nc)
                    }
                }
            }
        }
    }
}
