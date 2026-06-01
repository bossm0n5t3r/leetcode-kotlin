package me.bossm0n5t3r.leetcode.maximumErasureValue

class MaximumErasureValue {
    class Solution {
        fun maximumUniqueSubarray(nums: IntArray): Int {
            var result = 0
            var start = 0
            val cache = mutableMapOf<Int, Int>()
            val partialSum = IntArray(nums.size) { 0 }
            nums.forEachIndexed { end, num ->
                partialSum[end] = partialSum.getOrElse(end - 1) { 0 } + num
                if (cache.containsKey(num)) {
                    val previousIdx = cache[num]!!
                    while (start <= previousIdx) {
                        start++
                    }
                }
                result =
                    result.coerceAtLeast(partialSum[end] - partialSum.getOrElse(start - 1) { 0 })
                cache[num] = end
            }
            return result
        }

        fun maximumUniqueSubarrayAnotherWay(nums: IntArray): Int {
            // Fastest solution
            // https://leetcode.com/submissions/detail/720605108/
            val cache = mutableSetOf<Int>()
            var start = 0
            var end = 0
            var sum = 0
            var result = 0
            while (start < nums.size && end < nums.size) {
                if (!cache.contains(nums[end])) {
                    sum += nums[end]
                    result = result.coerceAtLeast(sum)
                    cache.add(nums[end++])
                } else {
                    sum -= nums[start]
                    cache.remove(nums[start++])
                }
            }
            return result
        }
    }
}
