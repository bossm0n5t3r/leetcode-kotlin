package me.bossm0n5t3r.leetcode.findAllGroupsOfFarmland

import java.util.LinkedList
import java.util.Queue

class FindAllGroupsOfFarmland {
    class Solution {
        fun findFarmland(land: Array<IntArray>): Array<IntArray> {
            val result = mutableListOf<IntArray>()
            val (m, n) = land.size to land[0].size
            val visited = Array(m) { BooleanArray(n) { false } }
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (land[r][c] == 0 || visited[r][c]) continue
                    val group = bfs(land, m, n, r, c, visited)
                    result.add(group)
                }
            }
            return result.toTypedArray()
        }

        private fun bfs(
            land: Array<IntArray>,
            m: Int,
            n: Int,
            curR: Int,
            curC: Int,
            visited: Array<BooleanArray>,
        ): IntArray {
            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)
            var leftUpper = Int.MAX_VALUE to Int.MAX_VALUE
            var rightDown = Int.MIN_VALUE to Int.MIN_VALUE
            val queue: Queue<Pair<Int, Int>> =
                LinkedList<Pair<Int, Int>>().apply { this.offer(curR to curC) }
            while (queue.isNotEmpty()) {
                val (r, c) = queue.poll()

                leftUpper =
                    (r to c).takeIf { leftUpper.first > r || leftUpper.second > c } ?: leftUpper
                rightDown =
                    (r to c).takeIf { rightDown.first < r || rightDown.second < c } ?: rightDown

                visited[r][c] = true
                for (i in 0 until 4) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if (
                        nr in 0 until m &&
                            nc in 0 until n &&
                            land[nr][nc] == 1 &&
                            visited[nr][nc].not()
                    ) {
                        visited[nr][nc] = true
                        queue.add(nr to nc)
                    }
                }
            }

            return intArrayOf(leftUpper.first, leftUpper.second, rightDown.first, rightDown.second)
        }
    }
}
