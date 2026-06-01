package me.bossm0n5t3r.leetcode.nearestExitFromEntranceInMaze

import java.util.LinkedList

class NearestExitFromEntranceInMaze {
    class Solution {
        fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
            val m = maze.size
            val n = maze.first().size

            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)

            val (entranceR, entranceC) = entrance
            val visited =
                Array(m) { BooleanArray(n) { false } }.apply { this[entranceR][entranceC] = true }
            val queue =
                LinkedList<MazeInfo>().apply {
                    val (r, c) = entrance
                    this.add(MazeInfo(r, c, 0))
                }
            while (queue.isNotEmpty()) {
                val size = queue.size
                repeat(size) {
                    val (curR, curC, step) = queue.poll()
                    if (curR == 0 || curR == m - 1 || curC == 0 || curC == n - 1) {
                        if (curR != entranceR || curC != entranceC) {
                            return step
                        }
                    }
                    for (i in 0 until 4) {
                        val nr = curR + dr[i]
                        val nc = curC + dc[i]
                        if (nr in 0 until m && nc in 0 until n) {
                            if (maze[nr][nc] == '.' && visited[nr][nc].not()) {
                                visited[nr][nc] = true
                                queue.add(MazeInfo(nr, nc, step + 1))
                            }
                        }
                    }
                }
            }
            return -1
        }

        data class MazeInfo(val r: Int, val c: Int, val step: Int)
    }
}
