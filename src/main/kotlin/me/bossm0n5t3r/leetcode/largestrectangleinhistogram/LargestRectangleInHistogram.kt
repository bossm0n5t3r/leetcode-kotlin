package me.bossm0n5t3r.leetcode.largestrectangleinhistogram

import java.util.Stack

class LargestRectangleInHistogram {
    class Solution {
        fun largestRectangleArea(heights: IntArray): Int {
            val n = heights.size
            val stack = Stack<Int>()
            var result = 0
            for (i in 0..n) {
                val currentHeight = if (i < n) heights[i] else 0
                while (stack.isNotEmpty() && heights[stack.peek()] > currentHeight) {
                    val index = stack.pop()
                    val height = heights[index]
                    val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                    result = maxOf(result, height * width)
                }
                if (i < n) {
                    stack.push(i)
                }
            }
            return result
        }
    }
}
