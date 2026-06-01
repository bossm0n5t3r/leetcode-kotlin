package me.bossm0n5t3r.leetcode.thekthlexicographicalstringofallhappystringsoflengthn

class TheKThLexicographicalStringOfAllHappyStringsOfLengthN {
    class Solution {
        fun getHappyString(n: Int, k: Int): String {
            val result = mutableListOf<String>()
            val chars = charArrayOf('a', 'b', 'c')
            dfs(chars, n, 0, "", result)
            return if (result.size < k) "" else result[k - 1]
        }

        private fun dfs(
            chars: CharArray,
            n: Int,
            index: Int,
            cur: String,
            result: MutableList<String>,
        ) {
            if (index == n) {
                result.add(cur)
                return
            }
            for (i in 0 until 3) {
                if (cur.isEmpty() || cur.last() != chars[i]) {
                    dfs(chars, n, index + 1, cur + chars[i], result)
                }
            }
        }
    }
}
