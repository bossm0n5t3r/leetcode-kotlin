package me.bossm0n5t3r.leetcode.minimumAbsoluteDifferenceQueries

import kotlin.math.min

class MinimumAbsoluteDifferenceQueries {
    class Solution {
        /**
         * @link
         *   https://leetcode.com/problems/minimum-absolute-difference-queries/discuss/1284329/Java-or-Prefix-sum-or-Easy-to-Understand-or-What-if-constraints-were-different
         */
        fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
            val n = nums.size
            val count = Array(n + 1) { IntArray(100) { 0 } }
            (0 until n).forEach { i ->
                (0 until 100).forEach { j -> count[i + 1][j] = count[i][j] }
                ++count[i + 1][nums[i] - 1]
            }

            return queries
                .map { (low, b) ->
                    val high = b + 1
                    val present = mutableListOf<Int>()
                    var min = 100

                    (0 until min).forEach { j ->
                        if (count[high][j] - count[low][j] != 0) {
                            present.add(j)
                        }
                    }
                    (1 until present.size).forEach { j ->
                        min = min(min, present[j] - present[j - 1])
                    }
                    if (present.size == 1) {
                        min = -1
                    }
                    min
                }
                .toIntArray()
        }
    }
}
