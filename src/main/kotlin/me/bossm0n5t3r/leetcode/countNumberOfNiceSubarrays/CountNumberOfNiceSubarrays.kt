package me.bossm0n5t3r.leetcode.countNumberOfNiceSubarrays

class CountNumberOfNiceSubarrays {
    class Solution {
        fun numberOfSubarrays(nums: IntArray, k: Int): Int {
            val n = nums.size
            val cnt = IntArray(n + 1)
            cnt[0] = 1
            var ans = 0
            var t = 0
            for (num in nums) {
                t += num and 1
                if (t - k >= 0) {
                    ans += cnt[t - k]
                }
                cnt[t]++
            }
            return ans
        }
    }
}
