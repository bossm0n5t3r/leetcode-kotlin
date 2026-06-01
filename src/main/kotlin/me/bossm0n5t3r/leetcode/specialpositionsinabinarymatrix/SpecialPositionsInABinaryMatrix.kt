package me.bossm0n5t3r.leetcode.specialpositionsinabinarymatrix

class SpecialPositionsInABinaryMatrix {
    class Solution {
        fun numSpecial(mat: Array<IntArray>): Int {
            val (m, n) = mat.size to mat.first().size
            var answer = 0
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (mat[r][c] == 1 && mat.isSpecial(r, c)) {
                        answer++
                    }
                }
            }
            return answer
        }

        private fun Array<IntArray>.isSpecial(curR: Int, curC: Int): Boolean {
            val (m, n) = this.size to this.first().size
            for (r in 0 until m) {
                if (r != curR && this[r][curC] == 1) return false
            }
            for (c in 0 until n) {
                if (c != curC && this[curR][c] == 1) return false
            }
            return true
        }
    }
}
