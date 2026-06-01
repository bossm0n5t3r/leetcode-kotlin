package me.bossm0n5t3r.leetcode.strangePrinter

class StrangePrinter {
    class Solution {
        fun strangePrinter(s: String): Int {
            val removeDuplicatedString = removeDuplicates(s)
            val n = removeDuplicatedString.length
            val memo = Array(n) { arrayOfNulls<Int>(n) }
            return minimumTurns(0, n - 1, removeDuplicatedString, memo)
        }

        private fun minimumTurns(start: Int, end: Int, s: String, memo: Array<Array<Int?>>): Int {
            // Base case: empty string requires 0 turns
            if (start > end) {
                return 0
            }

            // If result is memoized, return it
            val memoized = memo[start][end]
            if (memoized != null) {
                return memoized
            }

            // Initialize with worst case: print each character separately
            var minTurns = 1 + minimumTurns(start + 1, end, s, memo)

            // Try to optimize by finding matching characters
            for (k in start + 1..end) {
                if (s[k] == s[start]) {
                    // If match found, try splitting the problem
                    val turnsWithMatch =
                        minimumTurns(start, k - 1, s, memo) + minimumTurns(k + 1, end, s, memo)
                    minTurns = minOf(minTurns, turnsWithMatch)
                }
            }

            // Memoize and return the result
            return minTurns.also { memo[start][end] = it }
        }

        private fun removeDuplicates(s: String): String =
            s.fold(StringBuilder()) { acc: StringBuilder, c: Char ->
                    if (acc.lastOrNull() != c) {
                        acc.append(c)
                    } else {
                        acc
                    }
                }
                .toString()
    }
}
