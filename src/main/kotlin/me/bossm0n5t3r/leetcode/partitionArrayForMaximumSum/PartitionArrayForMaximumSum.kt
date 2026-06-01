package me.bossm0n5t3r.leetcode.partitionArrayForMaximumSum

class PartitionArrayForMaximumSum {
    class Solution {
        fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
            // Length of the input array
            val n = arr.size

            // Dynamic programming table to store maximum sum at each position
            val dp = IntArray(n + 1)

            // Iterate through the array elements
            for (i in 0 until n) {
                var curMax = 0
                var curSum = 0

                // Iterate over the last k elements or until the beginning of the array
                for (j in i downTo maxOf(0, i - k + 1)) {
                    // Update the maximum value in the current partition
                    curMax = maxOf(curMax, arr[j])

                    // Calculate the current sum considering the maximum value in the partition
                    val cur = curMax * (i - j + 1) + dp[j]

                    // Update the current sum if the new one is greater
                    curSum = maxOf(curSum, cur)
                }

                // Update the dynamic programming table with the maximum sum at the current position
                dp[i + 1] = curSum
            }

            return dp[n]
        }
    }
}
