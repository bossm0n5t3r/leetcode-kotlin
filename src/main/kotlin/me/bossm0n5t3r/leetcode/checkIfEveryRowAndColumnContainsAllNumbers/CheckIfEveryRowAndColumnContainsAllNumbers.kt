package me.bossm0n5t3r.leetcode.checkIfEveryRowAndColumnContainsAllNumbers

class CheckIfEveryRowAndColumnContainsAllNumbers {
    class Solution {
        fun checkValid(matrix: Array<IntArray>): Boolean =
            matrix.all { it.checkValid() } && matrix.transpose().all { it.checkValid() }

        private fun IntArray.checkValid(): Boolean = this.toSet().size == this.size

        private fun Array<IntArray>.transpose(): Array<IntArray> =
            Array(this[0].size) { i -> Array(this.size) { j -> this[j][i] }.toIntArray() }
    }
}
