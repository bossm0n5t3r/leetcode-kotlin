package me.bossm0n5t3r.leetcode.minimumNumberOfKConsecutiveBitFlips

class MinimumNumberOfKConsecutiveBitFlips {
    class Solution {
        fun minKBitFlips(nums: IntArray, k: Int): Int {
            var ans = 0
            val n = nums.size
            val diff = IntArray(n + 1)
            var revCnt = 0
            for (i in 0 until n) {
                revCnt += diff[i]
                if ((nums[i] + revCnt) % 2 == 0) {
                    if (i + k > n) return -1
                    ans++
                    revCnt++
                    diff[i + k]--
                }
            }
            return ans
        }
    }
}
