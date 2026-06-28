package me.bossm0n5t3r.leetcode.maximumelementafterdecreasingandrearranging

class MaximumElementAfterDecreasingAndRearranging {
    class Solution {
        fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
            arr.sort()
            arr[0] = 1
            for (i in 1 until arr.size) {
                if (arr[i] - arr[i - 1] <= 1) continue
                arr[i] = arr[i - 1] + 1
            }
            return arr.last()
        }
    }
}
