package me.bossm0n5t3r.leetcode.countunguardedcellsinthegrid

class CountUnguardedCellsInTheGrid {
    class Solution {
        fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
            // wall: 1, guard: 2, guarded: 3, not guarded: 0
            val grid = Array(m) { IntArray(n) }
            var result = m * n
            for ((wallR, wallC) in walls) {
                grid[wallR][wallC] = 1
                result--
            }
            for ((guardR, guardC) in guards) {
                grid[guardR][guardC] = 2
                result--
            }
            for ((guardR, guardC) in guards) {
                // north
                var step = 1
                while (
                    guardR - step >= 0 &&
                        (grid[guardR - step][guardC] == 0 || grid[guardR - step][guardC] == 3)
                ) {
                    val cur = grid[guardR - step][guardC]
                    if (cur == 3) {
                        step++
                        continue
                    }
                    if (cur == 0) {
                        grid[guardR - step][guardC] = 3
                        step++
                        result--
                    }
                }
                // east
                step = 1
                while (
                    guardC + step < n &&
                        (grid[guardR][guardC + step] == 0 || grid[guardR][guardC + step] == 3)
                ) {
                    val cur = grid[guardR][guardC + step]
                    if (cur == 3) {
                        step++
                        continue
                    }
                    if (cur == 0) {
                        grid[guardR][guardC + step] = 3
                        step++
                        result--
                    }
                }
                // south
                step = 1
                while (
                    guardR + step < m &&
                        (grid[guardR + step][guardC] == 0 || grid[guardR + step][guardC] == 3)
                ) {
                    val cur = grid[guardR + step][guardC]
                    if (cur == 3) {
                        step++
                        continue
                    }
                    if (cur == 0) {
                        grid[guardR + step][guardC] = 3
                        step++
                        result--
                    }
                }
                // west
                step = 1
                while (
                    guardC - step >= 0 &&
                        (grid[guardR][guardC - step] == 0 || grid[guardR][guardC - step] == 3)
                ) {
                    val cur = grid[guardR][guardC - step]
                    if (cur == 3) {
                        step++
                        continue
                    }
                    if (cur == 0) {
                        grid[guardR][guardC - step] = 3
                        step++
                        result--
                    }
                }
            }
            return result
        }
    }
}
