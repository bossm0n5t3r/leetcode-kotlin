package me.bossm0n5t3r.leetcode.rottingOranges

import java.util.LinkedList

class RottingOranges {
    class Solution {
        fun orangesRotting(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size

            val visited = Array(m) { BooleanArray(n) { false } }
            val rottenOranges = LinkedList<Pair<Int, Int>>()
            var freshOrangesCount = 0
            for (r in 0 until m) {
                for (c in 0 until n) {
                    when (grid[r][c]) {
                        1 -> {
                            freshOrangesCount++
                        }

                        2 -> {
                            rottenOranges.add(r to c)
                            visited[r][c] = true
                        }
                    }
                }
            }

            val dr = intArrayOf(0, 0, 1, -1)
            val dc = intArrayOf(1, -1, 0, 0)

            var minute = 0
            while (rottenOranges.isNotEmpty()) {
                if (freshOrangesCount == 0) return minute
                val size = rottenOranges.size
                repeat(size) {
                    val (r, c) = rottenOranges.poll()
                    for (i in 0 until 4) {
                        val nr = r + dr[i]
                        val nc = c + dc[i]

                        if (nr in 0 until m && nc in 0 until n) {
                            if (grid[nr][nc] == 1 && visited[nr][nc].not()) {
                                visited[nr][nc] = true
                                freshOrangesCount--
                                rottenOranges.add(nr to nc)
                            }
                        }
                    }
                }
                minute++
            }
            return if (freshOrangesCount == 0) minute else -1
        }
    }
}
