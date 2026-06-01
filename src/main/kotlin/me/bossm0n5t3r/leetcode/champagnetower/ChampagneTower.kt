package me.bossm0n5t3r.leetcode.champagnetower

class ChampagneTower {
    class Solution {
        fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
            val tower = Array(102) { DoubleArray(102) }
            tower[0][0] = poured.toDouble()
            for (r in 0..queryRow) {
                for (c in 0..r) {
                    val q = (tower[r][c] - 1.0) / 2.0
                    if (q > 0) {
                        tower[r + 1][c] += q
                        tower[r + 1][c + 1] += q
                    }
                }
            }
            return tower[queryRow][queryGlass].coerceAtMost(1.000)
        }
    }
}
