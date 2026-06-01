package me.bossm0n5t3r.leetcode.shift2DGrid

class Shift2DGrid {
    class Solution {
        fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
            val m = grid.size
            val n = grid.first().size
            return grid
                .flatMap { it.toList() }
                .let { it.takeLast(k % (m * n)) + it.dropLast(k % (m * n)) }
                .chunked(n)
        }
    }
}
