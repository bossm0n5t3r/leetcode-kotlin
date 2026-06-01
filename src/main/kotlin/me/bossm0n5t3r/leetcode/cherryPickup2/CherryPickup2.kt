package me.bossm0n5t3r.leetcode.cherryPickup2

class CherryPickup2 {
    class Solution {
        fun cherryPickup(grid: Array<IntArray>): Int {
            val row = grid.size
            val col = grid[0].size
            val dp = Array(row + 1) { Array(col + 1) { IntArray(col + 1) { -1 } } }
            var result = 0
            dp[0][0][col - 1] = grid[0][0] + grid[0][col - 1]

            for (r in 1 until row) {
                for (robotA in 0 until col) {
                    for (robotB in robotA + 1 until col) {
                        var max = -1
                        for (tmpR in -1..1) {
                            for (tmpC in -1..1) {
                                if (robotA + tmpR in 0 until col && robotB + tmpC in 0 until col) {
                                    max = maxOf(max, dp[r - 1][robotA + tmpR][robotB + tmpC])
                                }
                            }
                        }
                        if (max != -1) {
                            dp[r][robotA][robotB] = max + grid[r][robotA] + grid[r][robotB]
                            result = maxOf(result, dp[r][robotA][robotB])
                        }
                    }
                }
            }

            return result
        }
    }
}
