package me.bossm0n5t3r.leetcode.maximumelementafterdecreasingandrearranging

class MaximumElementAfterDecreasingAndRearranging {
    class Solution {
        fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
            val n = arr.size
            val counts = IntArray(n + 1)
            for (num in arr) {
                counts[minOf(num, n)]++
            }
            var ans = 1
            for (i in 2..n) {
                ans = minOf(ans + counts[i], i)
            }
            return ans
        }
    }
}
