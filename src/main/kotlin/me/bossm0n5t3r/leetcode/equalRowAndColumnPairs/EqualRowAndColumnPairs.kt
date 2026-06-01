package me.bossm0n5t3r.leetcode.equalRowAndColumnPairs

class EqualRowAndColumnPairs {
    class Solution {
        fun equalPairs(grid: Array<IntArray>): Int {
            val transpose = transpose(grid)

            return grid.sumOf { row ->
                val rowList = row.toList()
                transpose.count { col -> col == rowList }
            }
        }

        private fun transpose(grid: Array<IntArray>): Array<List<Int>> =
            Array(grid.first().size) { j -> List(grid.size) { i -> grid[i][j] } }
    }
}
