package me.bossm0n5t3r.leetcode.shortestPathInBinaryMatrix

import java.util.LinkedList

class ShortestPathInBinaryMatrix {
    class Solution {
        fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
            if (grid[0][0] != 0) return -1
            val n = grid.size
            val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
            val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
            val queue = LinkedList<Pair<Point, Int>>()
            val visited = Array(n) { BooleanArray(n) { false } }
            queue.add(Point(0, 0) to 1)
            visited[0][0] = true
            val indices = (0 until n)
            while (queue.isNotEmpty()) {
                val (curPoint, curDist) = queue.poll()
                val (curR, curC) = curPoint
                if (curR == n - 1 && curC == n - 1) return curDist
                (0 until 8).forEach {
                    val nr = curR + dr[it]
                    val nc = curC + dc[it]
                    if (
                        indices.contains(nr) &&
                            indices.contains(nc) &&
                            !visited[nr][nc] &&
                            grid[nr][nc] == 0
                    ) {
                        visited[nr][nc] = true
                        queue.add(Point(nr, nc) to (curDist + 1))
                    }
                }
            }
            return -1
        }

        private data class Point(val r: Int, val c: Int)
    }
}
