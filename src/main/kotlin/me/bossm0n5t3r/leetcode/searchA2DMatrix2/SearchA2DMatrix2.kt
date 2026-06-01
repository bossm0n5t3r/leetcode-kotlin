package me.bossm0n5t3r.leetcode.searchA2DMatrix2

import java.util.LinkedList

class SearchA2DMatrix2 {
    class Solution {
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            val queue = LinkedList<Pair<Int, Int>>()
            val m = matrix.size
            val n = matrix.first().size
            val visited = Array(m) { BooleanArray(n) { false } }
            queue.add(Pair(0, 0))
            visited[0][0] = true
            while (queue.isNotEmpty()) {
                val (r, c) = queue.poll()
                if (matrix[r][c] == target) return true
                if (r + 1 < m && !visited[r + 1][c] && matrix[r + 1][c] <= target) {
                    visited[r + 1][c] = true
                    queue.add(Pair(r + 1, c))
                }
                if (c + 1 < n && !visited[r][c + 1] && matrix[r][c + 1] <= target) {
                    visited[r][c + 1] = true
                    queue.add(Pair(r, c + 1))
                }
            }
            return false
        }

        fun searchMatrixEfficient(matrix: Array<IntArray>, target: Int): Boolean {
            if (matrix.isEmpty() || matrix.first().isEmpty()) return false
            var row = 0
            var col = matrix.first().size - 1
            while (col >= 0 && row < matrix.size) {
                val cur = matrix[row][col]
                if (cur == target) {
                    return true
                } else if (cur < target) {
                    row++
                } else {
                    col--
                }
            }
            return false
        }
    }
}
