package me.bossm0n5t3r.leetcode.creategridwithexactlyonepath

class CreateGridWithExactlyOnePath {
    class Solution {
        fun createGrid(m: Int, n: Int): Array<String> {
            val result = Array(m) { CharArray(n) { '#' } }
            for (c in 0 until n) {
                result[0][c] = '.'
            }
            for (r in 0 until m) {
                result[r][n - 1] = '.'
            }
            return result.map { String(it) }.toTypedArray()
        }
    }
}
