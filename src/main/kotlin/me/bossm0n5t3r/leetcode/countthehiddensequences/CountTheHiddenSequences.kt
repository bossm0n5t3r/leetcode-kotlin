package me.bossm0n5t3r.leetcode.countthehiddensequences

class CountTheHiddenSequences {
    class Solution {
        fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            var acc = 0
            for (difference in differences) {
                acc += difference
                if (min > acc) {
                    min = acc
                }
                if (max < acc) {
                    max = acc
                }
            }
            val start = (lower - min).coerceAtLeast(lower)
            val end = (upper - max).coerceAtMost(upper)
            // println("start: $start, end: $end, lower: $lower, upper: $upper, min: $min, max:
            // $max")
            if (start > end) return 0
            if (start == end && min < lower - upper) return 0
            return end - start + 1
        }
    }
}
