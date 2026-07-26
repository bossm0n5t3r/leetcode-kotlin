package me.bossm0n5t3r.leetcode.maximumproductofthreenumbers

class MaximumProductOfThreeNumbers {
    class Solution {
        fun maximumProduct(nums: IntArray): Int {
            val candidates = IntArray(5) { Int.MIN_VALUE }
            candidates[0] = Int.MAX_VALUE
            candidates[1] = Int.MAX_VALUE
            for (num in nums) {
                when {
                    num < candidates[0] -> {
                        candidates[1] = candidates[0]
                        candidates[0] = num
                    }
                    num < candidates[1] -> candidates[1] = num
                }
                when {
                    num > candidates[4] -> {
                        candidates[2] = candidates[3]
                        candidates[3] = candidates[4]
                        candidates[4] = num
                    }
                    num > candidates[3] -> {
                        candidates[2] = candidates[3]
                        candidates[3] = num
                    }
                    num > candidates[2] -> {
                        candidates[2] = num
                    }
                }
            }
            return maxOf(
                candidates[0] * candidates[1] * candidates[4],
                candidates[2] * candidates[3] * candidates[4],
            )
        }
    }
}
