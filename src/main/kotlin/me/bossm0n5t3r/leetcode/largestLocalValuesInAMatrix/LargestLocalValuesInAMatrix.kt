package me.bossm0n5t3r.leetcode.largestLocalValuesInAMatrix

class LargestLocalValuesInAMatrix {
    class Solution {
        fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
            val n = grid.size
            val result = Array(n - 2) { IntArray(n - 2) { 0 } }
            for (r in (0 until n - 2)) {
                for (c in 0 until n - 2) {
                    result[r][c] =
                        listOf(
                                grid[r][c],
                                grid[r][c + 1],
                                grid[r][c + 2],
                                grid[r + 1][c],
                                grid[r + 1][c + 1],
                                grid[r + 1][c + 2],
                                grid[r + 2][c],
                                grid[r + 2][c + 1],
                                grid[r + 2][c + 2],
                            )
                            .max()
                }
            }
            return result
        }
    }
}
