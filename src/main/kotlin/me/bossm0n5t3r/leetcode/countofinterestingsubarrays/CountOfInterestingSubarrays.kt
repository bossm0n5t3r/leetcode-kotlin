package me.bossm0n5t3r.leetcode.countofinterestingsubarrays

class CountOfInterestingSubarrays {
    class Solution {
        fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
            val n = nums.size
            val cnt = mutableMapOf<Int, Int>()
            var prefix = 0
            var result = 0L
            cnt += 0 to 1
            for (i in 0 until n) {
                prefix += if (nums[i] % modulo == k) 1 else 0
                result += cnt.getOrDefault((prefix - k + modulo) % modulo, 0).toLong()
                cnt[prefix % modulo] = cnt.getOrDefault(prefix % modulo, 0) + 1
            }
            return result
        }
    }
}
