package me.bossm0n5t3r.leetcode.findxvalueofarrayi

class FindXValueOfArrayI {
    class Solution {
        fun resultArray(nums: IntArray, k: Int): LongArray {
            val result = LongArray(k)
            var prev = LongArray(k)
            for (num in nums) {
                val cur = LongArray(k)
                val remainder = num % k
                cur[remainder] += 1
                for (r in 0 until k) {
                    if (prev[r] == 0L) continue
                    val numRemainder = num % k
                    val newRemainder = (r * numRemainder) % k
                    cur[newRemainder] += prev[r]
                }
                for (r in 0 until k) result[r] += cur[r]
                prev = cur
            }
            return result
        }
    }
}
