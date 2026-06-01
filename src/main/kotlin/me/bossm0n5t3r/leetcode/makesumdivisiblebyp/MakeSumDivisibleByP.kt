package me.bossm0n5t3r.leetcode.makesumdivisiblebyp

class MakeSumDivisibleByP {
    class Solution {
        fun minSubarray(nums: IntArray, p: Int): Int {
            val n = nums.size
            val prefix = nums.runningFold(0) { acc, i -> (acc + i) % p }
            val total = prefix[n]
            if (total % p == 0) return 0
            var result = n
            val last = mutableMapOf(0 to 0)
            for (i in 1..n) {
                val need = (prefix[i] - total + p) % p
                val lastIndexOfNeed = last[need]
                if (lastIndexOfNeed != null) {
                    result = minOf(result, i - lastIndexOfNeed)
                }
                last[prefix[i]] = i
            }
            return if (result == n) -1 else result
        }
    }
}
