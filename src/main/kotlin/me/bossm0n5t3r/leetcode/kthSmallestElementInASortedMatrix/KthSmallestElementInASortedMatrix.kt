package me.bossm0n5t3r.leetcode.kthSmallestElementInASortedMatrix

class KthSmallestElementInASortedMatrix {
    class Solution {
        fun kthSmallest(matrix: Array<IntArray>, k: Int): Int =
            matrix.flatMap { it.toList() }.sorted()[k - 1]

        fun kthSmallestByUsingBiSect(matrix: Array<IntArray>, k: Int): Int = biSelect(matrix, k)

        private fun biSelect(matrix: Array<IntArray>, k: Int): Int {
            val n = matrix.size
            var low = matrix[0][0]
            var high = matrix[n - 1][n - 1] + 1
            while (low < high) {
                //            println("low: $low, high: $high")
                val mid = low + (high - low) / 2
                var count = 0
                var j = n - 1
                (0 until n).forEach { i ->
                    while (j >= 0 && matrix[i][j] > mid) j--
                    count += (j + 1)
                }
                if (count < k) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }
            return low
        }
    }
}
