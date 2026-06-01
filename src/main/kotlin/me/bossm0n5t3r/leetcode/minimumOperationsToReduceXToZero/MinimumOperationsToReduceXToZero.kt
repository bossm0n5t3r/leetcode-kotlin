package me.bossm0n5t3r.leetcode.minimumOperationsToReduceXToZero

class MinimumOperationsToReduceXToZero {
    class Solution {
        fun minOperations(nums: IntArray, x: Int): Int {
            if (nums.first() > x && nums.last() > x) return -1
            val totalSum = nums.sum()
            if (totalSum < x) return -1
            if (totalSum == x) return nums.size
            var result = 0
            var start = 0
            var sum = 0
            nums.indices.forEach { end ->
                sum += nums[end]
                while (start <= end && sum > totalSum - x) sum -= nums[start++]
                if (sum == totalSum - x) result = result.coerceAtLeast(end - start + 1)
            }
            return if (result == 0) -1 else nums.size - result
        }

        fun minOperationsUsingMap(nums: IntArray, x: Int): Int {
            if (nums.first() > x && nums.last() > x) return -1
            val totalSum = nums.sum()
            if (totalSum < x) return -1
            if (totalSum == x) return nums.size
            var result = Int.MIN_VALUE
            val cache = mutableMapOf(0 to -1)
            var sum = 0
            nums.forEachIndexed { index, num ->
                sum += num
                if (cache.containsKey(sum + x - totalSum)) {
                    result = result.coerceAtLeast(index - cache.getValue(sum + x - totalSum))
                }
                cache[sum] = index
            }
            return if (result == Int.MIN_VALUE) -1 else nums.size - result
        }
    }
}
