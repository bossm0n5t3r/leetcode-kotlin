package me.bossm0n5t3r.leetcode.twosum

class TwoSum {
    class Solution {
        fun twoSumBruteForce(nums: IntArray, target: Int): IntArray {
            if (nums.size == 2) return intArrayOf(0, 1)
            val length = nums.size
            for (i in 0 until length - 1) {
                val complement = target - nums[i]
                for (j in i + 1 until length) {
                    if (nums[j] == complement) return intArrayOf(i, j)
                }
            }
            return intArrayOf()
        }

        fun twoSumHashTable(nums: IntArray, target: Int): IntArray {
            val map = mutableMapOf<Int, Int>()
            val length = nums.size
            var complement: Int
            for (i in 0 until length) {
                complement = target - nums[i]
                if (map.containsKey(complement)) {
                    return intArrayOf(map[complement]!!, i)
                }
                map[nums[i]] = i
            }
            return intArrayOf()
        }
    }
}
