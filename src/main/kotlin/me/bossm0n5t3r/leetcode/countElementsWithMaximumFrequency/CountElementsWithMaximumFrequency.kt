package me.bossm0n5t3r.leetcode.countElementsWithMaximumFrequency

class CountElementsWithMaximumFrequency {
    class Solution {
        fun maxFrequencyElements(nums: IntArray): Int {
            val elementToFrequency = nums.toList().groupingBy { it }.eachCount()
            val maxFrequency = elementToFrequency.values.maxOrNull() ?: 0
            return elementToFrequency.filter { it.value == maxFrequency }.values.sum()
        }
    }
}
