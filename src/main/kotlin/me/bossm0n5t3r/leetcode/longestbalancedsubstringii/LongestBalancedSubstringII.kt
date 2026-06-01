package me.bossm0n5t3r.leetcode.longestbalancedsubstringii

class LongestBalancedSubstringII {
    class Solution {
        fun longestBalanced(s: String): Int {
            // Maps store the first occurrence of a specific difference (state)
            val ab = mutableMapOf<Long, Long>()
            val bc = mutableMapOf<Long, Long>()
            val ca = mutableMapOf<Long, Long>()
            val abc = mutableMapOf<Long, Long>()

            var countA: Long = 0
            var countB: Long = 0
            var countC: Long = 0
            var longestLength: Long = 1

            // Base case: at index 0 (start), the state is "0 differences"
            ab[0L] = 0L
            bc[0L] = 0L
            ca[0L] = 0L
            abc[0L] = 0L

            // Handle same-character substrings (e.g., "aaaa")
            var currentChar = s[0]
            var len: Long = 0
            for (i in 0..<s.length) {
                if (currentChar == s[i]) {
                    len++
                } else {
                    len = 1
                    currentChar = s[i]
                }
                longestLength = maxOf(longestLength, len)
            }

            fun putOrUpdateLongestLength(i: Int, id: Long, map: MutableMap<Long, Long>) {
                val value = map[id]
                if (value == null) {
                    map[id] = i.toLong() + 1
                } else {
                    longestLength = maxOf(longestLength, i - value + 1)
                }
            }

            // Handle balanced substrings using Prefix Sums
            for (i in 0..<s.length) {
                val ch = s[i]
                when (ch) {
                    'a' -> countA++
                    'b' -> countB++
                    else -> countC++
                }

                val abId = ((countB - countA) shl 32) or (countC and 0xFFFFFFFFL)
                val bcId = ((countB - countC) shl 32) or (countA and 0xFFFFFFFFL)
                val caId = ((countC - countA) shl 32) or (countB and 0xFFFFFFFFL)
                val abcId = ((countB - countA) shl 32) or ((countC - countA) and 0xFFFFFFFFL)

                putOrUpdateLongestLength(i, abId, ab)
                putOrUpdateLongestLength(i, bcId, bc)
                putOrUpdateLongestLength(i, caId, ca)
                putOrUpdateLongestLength(i, abcId, abc)
            }
            return longestLength.toInt()
        }
    }
}
