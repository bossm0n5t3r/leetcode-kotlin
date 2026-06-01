package me.bossm0n5t3r.leetcode.uniquePaths3

import java.util.LinkedList

class UniquePaths3 {
    class Solution {
        fun uniquePathsIIIUsingBFS(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid.first().size
            lateinit var start: String
            lateinit var end: String
            val emptySquares = mutableSetOf<String>()
            val obstacles = mutableSetOf<String>()
            (0 until m).forEach { r ->
                (0 until n).forEach { c ->
                    val point = "$r$c"
                    when (grid[r][c]) {
                        0 -> {
                            emptySquares.add(point)
                        }

                        1 -> {
                            start = point
                        }

                        2 -> {
                            end = point
                        }

                        -1 -> {
                            obstacles.add(point)
                        }
                    }
                }
            }
            return bfs(m, n, start, end, emptySquares)
        }

        private fun bfs(
            m: Int,
            n: Int,
            start: String,
            end: String,
            emptySquares: MutableSet<String>,
        ): Int {
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)

            var result = 0
            val queue = LinkedList<Pair<String, MutableSet<String>>>()
            val notVisited = emptySquares.toMutableSet()
            notVisited.add(end)
            queue.add(start to notVisited)

            while (queue.isNotEmpty()) {
                val (curPoint, willVisited) = queue.poll()
                if (willVisited.isEmpty() && curPoint == end) {
                    result++
                    continue
                }
                val r = curPoint[0].digitToInt()
                val c = curPoint[1].digitToInt()
                (0 until 4).forEach { i ->
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    val next = "$nr$nc"
                    if (
                        (0 until m).contains(nr) &&
                            (0 until n).contains(nc) &&
                            willVisited.contains(next)
                    ) {
                        val nextWillVisited = willVisited.toMutableSet()
                        nextWillVisited.remove(next)
                        queue.add(next to nextWillVisited)
                    }
                }
            }
            return result
        }

        fun uniquePathsIIIUsingDFS(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid.first().size
            var (startR, startC) = -1 to -1
            var empty = 1
            (0 until m).forEach { r ->
                (0 until n).forEach { c ->
                    if (grid[r][c] == 0) {
                        empty++
                    } else if (grid[r][c] == 1) {
                        startR = r
                        startC = c
                    }
                }
            }
            val result = IntWrapper()
            dfs(grid, m, n, startR, startC, empty, result)
            return result.value
        }

        private fun dfs(
            grid: Array<IntArray>,
            m: Int,
            n: Int,
            r: Int,
            c: Int,
            empty: Int,
            result: IntWrapper,
        ) {
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] < 0) return
            if (grid[r][c] == 2) {
                if (empty == 0) {
                    result.value++
                }
                return
            }
            grid[r][c] = -2
            dfs(grid, m, n, r, c + 1, empty - 1, result)
            dfs(grid, m, n, r, c - 1, empty - 1, result)
            dfs(grid, m, n, r + 1, c, empty - 1, result)
            dfs(grid, m, n, r - 1, c, empty - 1, result)
            grid[r][c] = 0
        }

        private data class IntWrapper(var value: Int = 0)
    }
}
