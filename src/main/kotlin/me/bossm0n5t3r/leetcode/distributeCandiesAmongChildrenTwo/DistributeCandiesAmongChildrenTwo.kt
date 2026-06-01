package me.bossm0n5t3r.leetcode.distributeCandiesAmongChildrenTwo

class DistributeCandiesAmongChildrenTwo {
    class Solution {
        fun distributeCandies(n: Int, limit: Int): Long {
            var result = 0L
            for (i in 0..minOf(n, limit)) {
                val remain = n - i
                if (2 * limit < remain) {
                    continue
                }
                result += 2 * minOf(remain, limit) - remain + 1
            }
            return result
        }
    }
}
