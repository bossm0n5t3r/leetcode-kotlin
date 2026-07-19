package me.bossm0n5t3r.leetcode.smallestsubsequenceofdistinctcharacters

class SmallestSubsequenceOfDistinctCharacters {
    class Solution {
        fun smallestSubsequence(s: String): String {
            val last = IntArray(26)
            val used = BooleanArray(26)
            val stack = mutableListOf<Char>()

            for (i in s.indices) {
                last[s[i] - 'a'] = i
            }

            for (i in s.indices) {
                val c = s[i]
                if (used[c - 'a']) continue

                while (stack.isNotEmpty() && stack.last() > c && last[stack.last() - 'a'] > i) {
                    used[stack.last() - 'a'] = false
                    stack.removeLast()
                }

                stack.add(c)
                used[c - 'a'] = true
            }

            return stack.joinToString("")
        }
    }
}
