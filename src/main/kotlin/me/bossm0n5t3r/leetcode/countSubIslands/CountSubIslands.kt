package me.bossm0n5t3r.leetcode.countSubIslands

import java.util.LinkedList
import java.util.Queue

class CountSubIslands {
    class Solution {
        private data class Point(val r: Int, val c: Int)

        private val dr = intArrayOf(0, 0, 1, -1)
        private val dc = intArrayOf(1, -1, 0, 0)

        fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
            var result = 0
            val (m, n) = grid1.size to grid1[0].size
            val visited = Array(m) { BooleanArray(n) }
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (grid2[r][c] == 1 && visited[r][c].not()) {
                        val tmp = bfs(grid2, m, n, visited, r, c)
                        var isAllIslandsInGrid1 = true
                        for ((tmpR, tmpC) in tmp) {
                            if (grid1[tmpR][tmpC] != 1) {
                                isAllIslandsInGrid1 = false
                                break
                            }
                        }
                        if (isAllIslandsInGrid1) {
                            result++
                        }
                    }
                }
            }
            return result
        }

        private fun bfs(
            grid: Array<IntArray>,
            m: Int,
            n: Int,
            visited: Array<BooleanArray>,
            curR: Int,
            curC: Int,
        ): Set<Point> {
            val result = mutableSetOf<Point>()
            val queue: Queue<Point> = LinkedList<Point>().apply { this.offer(Point(curR, curC)) }
            while (queue.isNotEmpty()) {
                val curPoint = queue.poll()
                result.add(curPoint)
                val (r, c) = curPoint
                visited[r][c] = true
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (
                        nr in 0 until m &&
                            nc in 0 until n &&
                            grid[nr][nc] == 1 &&
                            visited[nr][nc].not()
                    ) {
                        visited[nr][nc] = true
                        queue.offer(Point(nr, nc))
                    }
                }
            }
            return result
        }
    }
}
