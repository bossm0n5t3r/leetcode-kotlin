package me.bossm0n5t3r.leetcode.mapofhighestpeak

class MapOfHighestPeak {
    class Solution {
        fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
            val (m, n) = isWater.size to isWater.first().size
            val queue = mutableListOf<Triple<Int, Int, Int>>()
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (isWater[r][c] == 1) {
                        queue += Triple(r, c, 0)
                    }
                }
            }
            val diff = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
            val result = Array(m) { IntArray(n) { Int.MAX_VALUE } }
            val visited = Array(m) { BooleanArray(n) }
            while (queue.isNotEmpty()) {
                val (r, c, height) = queue.removeFirst()
                visited[r][c] = true
                result[r][c] = minOf(result[r][c], height)
                for ((dr, dc) in diff) {
                    val nr = r + dr
                    val nc = c + dc
                    if (
                        nr in 0 until m &&
                            nc in 0 until n &&
                            visited[nr][nc].not() &&
                            result[nr][nc] == Int.MAX_VALUE
                    ) {
                        visited[nr][nc] = true
                        queue += Triple(nr, nc, height + 1)
                    }
                }
            }
            return result
        }
    }
}
