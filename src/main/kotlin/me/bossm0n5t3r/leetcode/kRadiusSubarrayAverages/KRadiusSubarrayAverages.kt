package me.bossm0n5t3r.leetcode.kRadiusSubarrayAverages

class KRadiusSubarrayAverages {
    class Solution {
        fun getAverages(nums: IntArray, k: Int): IntArray {
            val result = IntArray(nums.size) { -1 }
            val diameter = 2 * k + 1
            if (nums.size < diameter) return result

            var tmp = nums.map { it.toLong() }.subList(0, diameter).sum()
            for (i in k until nums.size - k) {
                result[i] = (tmp / diameter).toInt()
                if (i < nums.size - k - 1) {
                    tmp += nums[i + k + 1]
                }
                tmp -= nums[i - k]
            }
            return result
        }
    }
}
