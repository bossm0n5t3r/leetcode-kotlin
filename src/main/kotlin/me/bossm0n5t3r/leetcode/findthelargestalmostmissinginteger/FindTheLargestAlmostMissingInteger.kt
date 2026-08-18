package me.bossm0n5t3r.leetcode.findthelargestalmostmissinginteger

class FindTheLargestAlmostMissingInteger {
    class Solution {
        fun largestInteger(nums: IntArray, k: Int): Int {
            if (k == nums.size) return nums.max()

            if (k == 1) {
                val frequency = mutableMapOf<Int, Int>().withDefault { 0 }
                for (num in nums) {
                    frequency[num] = frequency.getValue(num) + 1
                }

                var found = false
                var largest = 0
                for ((num, count) in frequency) {
                    if (count == 1 && (!found || num > largest)) {
                        found = true
                        largest = num
                    }
                }
                return if (found) largest else -1
            }

            // For 1 < k < nums.size, every interior index belongs to at least two windows.
            // Therefore, only a globally unique endpoint can be almost missing.
            val first = nums.first()
            val last = nums.last()
            var firstCount = 0
            var lastCount = 0

            for (num in nums) {
                if (num == first) firstCount++
                if (num == last) lastCount++
            }

            return when {
                firstCount == 1 && lastCount == 1 -> maxOf(first, last)
                firstCount == 1 -> first
                lastCount == 1 -> last
                else -> -1
            }
        }
    }
}
