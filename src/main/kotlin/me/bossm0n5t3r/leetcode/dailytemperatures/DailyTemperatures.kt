package me.bossm0n5t3r.leetcode.dailytemperatures

import java.util.Stack

class DailyTemperatures {
    class Solution {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            val n = temperatures.size
            val deque = Stack<Int>()
            val result = IntArray(n)
            for (i in n - 1 downTo 0) {
                if (deque.isEmpty()) {
                    deque.push(i)
                    result[i] = 0
                    continue
                }
                while (deque.isNotEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                    deque.pop()
                }
                result[i] = if (deque.isNotEmpty()) deque.peek() - i else 0
                deque.push(i)
            }
            return result
        }
    }
}
