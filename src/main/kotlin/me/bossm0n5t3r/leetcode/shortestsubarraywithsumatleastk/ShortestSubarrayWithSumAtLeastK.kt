package me.bossm0n5t3r.leetcode.shortestsubarraywithsumatleastk

class ShortestSubarrayWithSumAtLeastK {
    class Solution {
        fun shortestSubarray(nums: IntArray, k: Int): Int {
            val n = nums.size
            val sum = nums.runningFold(0L) { num, acc -> acc + num }

            val q = IntArray(n + 1)
            var l = 0
            var r = 0
            var minLength = n + 1

            for (i in sum.indices) {
                while (r > l && sum[i] >= sum[q[l]] + k) {
                    minLength = minOf(minLength, (i - q[l++]))
                }

                while (r > l && sum[i] <= sum[q[r - 1]]) {
                    r--
                }

                q[r++] = i
            }

            return if (minLength <= n) minLength else -1
        }
    }
}
