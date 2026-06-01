package me.bossm0n5t3r.leetcode.firstcompletelypaintedroworcolumn

class FirstCompletelyPaintedRowOrColumn {
    class Solution {
        fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
            val (m, n) = mat.size to mat.first().size
            val rowVisited = IntArray(m) { 0 }
            val colVisited = IntArray(n) { 0 }
            val numToIndex =
                mat.mapIndexed { r, row -> row.mapIndexed { c, num -> num to (r to c) } }
                    .flatten()
                    .toMap()

            for ((index, num) in arr.withIndex()) {
                val (r, c) = numToIndex[num] ?: continue
                rowVisited[r]++
                colVisited[c]++
                if (rowVisited[r] == n || colVisited[c] == m) {
                    return index
                }
            }

            return -1
        }
    }
}
