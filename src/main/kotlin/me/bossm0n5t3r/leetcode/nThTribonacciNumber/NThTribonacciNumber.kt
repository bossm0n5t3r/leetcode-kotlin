package me.bossm0n5t3r.leetcode.nThTribonacciNumber

class NThTribonacciNumber {
    class Solution {
        fun tribonacci(n: Int): Int {
            val memory = mutableMapOf(0 to 0, 1 to 1, 2 to 1)
            return dp(memory, n)
        }

        private fun dp(memory: MutableMap<Int, Int>, n: Int): Int {
            if (memory.containsKey(n).not()) {
                memory[n] = dp(memory, n - 1) + dp(memory, n - 2) + dp(memory, n - 3)
            }
            return memory[n] ?: error("Not found $n")
        }
    }
}
