package me.bossm0n5t3r.leetcode.containerwithmostwater

class ContainerWithMostWater {
    class Solution {
        fun maxArea(height: IntArray): Int {
            var (s, e) = 0 to height.lastIndex
            var result = 0
            while (s < e) {
                result = maxOf(result, (e - s) * minOf(height[s], height[e]))
                if (height[s] < height[e]) s++ else e--
            }
            return result
        }
    }
}
