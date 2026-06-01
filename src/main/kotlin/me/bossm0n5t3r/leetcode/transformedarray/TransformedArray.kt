package me.bossm0n5t3r.leetcode.transformedarray

class TransformedArray {
    class Solution {
        fun constructTransformedArray(nums: IntArray): IntArray {
            val n = nums.size
            val result = IntArray(n)

            for (i in 0 until n) {
                val shift = nums[i]
                result[i] = if (shift == 0) 0 else nums[wrapIndex(i + shift, n)]
            }
            return result
        }

        private fun wrapIndex(index: Int, n: Int): Int {
            val mod = index % n
            return if (mod >= 0) mod else mod + n
        }
    }
}
