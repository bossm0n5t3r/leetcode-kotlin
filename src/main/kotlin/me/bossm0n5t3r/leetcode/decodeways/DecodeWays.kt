package me.bossm0n5t3r.leetcode.decodeways

class DecodeWays {
    class Solution {
        fun numDecodings(s: String): Int {
            val decodingChars = mutableSetOf<String>()
            for (i in 1..26) decodingChars += i.toString()
            val memo = IntArray(s.length) { -1 }
            return dfs(s, 0, decodingChars, memo)
        }

        private fun dfs(s: String, index: Int, decodingChars: Set<String>, memo: IntArray): Int {
            if (index == s.length) return 1

            if (memo[index] != -1) return memo[index]

            var result = 0

            val cur = s[index].toString()

            if (cur in decodingChars) {
                result += dfs(s, index + 1, decodingChars, memo)
            }

            if (index + 1 < s.length) {
                val next = s[index + 1].toString()
                if ("$cur$next" in decodingChars) {
                    result += dfs(s, index + 2, decodingChars, memo)
                }
            }

            memo[index] = result
            return result
        }
    }
}
