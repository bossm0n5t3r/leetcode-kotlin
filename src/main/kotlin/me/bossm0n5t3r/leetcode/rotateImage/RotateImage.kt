package me.bossm0n5t3r.leetcode.rotateImage

class RotateImage {
    class Solution {
        fun rotateMyFirstSolution(matrix: Array<IntArray>) {
            if (matrix.size == 1) return
            val n = matrix.size
            val depth = n / 2
            (1..depth).forEach { r ->
                (r - 1 until n - r).forEach { c -> rotateAt(Pair(r - 1, c), matrix, n) }
            }
        }

        private fun rotateAt(start: Pair<Int, Int>, matrix: Array<IntArray>, n: Int) {
            var beforeValue = matrix[start.first][start.second]
            var cur = start
            do {
                val next = Pair(cur.second, n - 1 - cur.first)
                val nextValue = matrix[next.first][next.second]
                matrix[next.first][next.second] = beforeValue
                cur = next
                if (cur != start) {
                    beforeValue = nextValue
                }
            } while (cur != start)
            matrix[start.first][start.second] = beforeValue
        }

        fun rotateApproachFirst(matrix: Array<IntArray>) {
            val n = matrix.size
            if (n == 1) return
            for (i in 0 until (n + 1) / 2) {
                for (j in 0 until n / 2) {
                    val temp = matrix[n - 1 - j][i]
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
                    matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]
                    matrix[j][n - 1 - i] = matrix[i][j]
                    matrix[i][j] = temp
                }
            }
        }

        fun rotateApproachSecond(matrix: Array<IntArray>) {
            transpose(matrix)
            reflect(matrix)
        }

        private fun transpose(matrix: Array<IntArray>) {
            val n = matrix.size
            for (i in 0 until n) {
                for (j in i until n) {
                    val tmp = matrix[j][i]
                    matrix[j][i] = matrix[i][j]
                    matrix[i][j] = tmp
                }
            }
        }

        private fun reflect(matrix: Array<IntArray>) {
            val n = matrix.size
            for (i in 0 until n) {
                for (j in 0 until n / 2) {
                    val tmp = matrix[i][j]
                    matrix[i][j] = matrix[i][n - j - 1]
                    matrix[i][n - j - 1] = tmp
                }
            }
        }
    }
}
