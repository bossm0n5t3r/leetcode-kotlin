package me.bossm0n5t3r.leetcode.sortedgcdpairqueries

class SortedGCDPairQueries {
    class Solution {
        fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
            val mx = nums.maxOrNull() ?: 0
            val freq = IntArray(mx + 1)
            for (x in nums) freq[x]++

            // exact[g] = number of pairs whose GCD is exactly g
            val exact = LongArray(mx + 1)
            for (g in mx downTo 1) {
                var count = 0L
                for (multiple in g..mx step g) {
                    count += freq[multiple]
                }
                // Pairs whose GCD is a multiple of g
                exact[g] = count * (count - 1) / 2
                // Subtract pairs whose GCD is a strict multiple of g
                var k = g + g
                while (k <= mx) {
                    exact[g] -= exact[k]
                    k += g
                }
            }

            // prefix[g] = number of pairs whose GCD is <= g
            val prefix = LongArray(mx + 1)
            for (g in 1..mx) {
                prefix[g] = prefix[g - 1] + exact[g]
            }

            val result = IntArray(queries.size)
            for (i in queries.indices) {
                val q = queries[i]
                var lo = 1
                var hi = mx
                var ans = mx
                while (lo <= hi) {
                    val mid = (lo + hi) ushr 1
                    if (prefix[mid] > q) {
                        ans = mid
                        hi = mid - 1
                    } else {
                        lo = mid + 1
                    }
                }
                result[i] = ans
            }
            return result
        }
    }
}
