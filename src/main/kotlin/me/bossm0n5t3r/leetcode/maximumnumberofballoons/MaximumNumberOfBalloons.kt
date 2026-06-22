package me.bossm0n5t3r.leetcode.maximumnumberofballoons

class MaximumNumberOfBalloons {
    class Solution {
        fun maxNumberOfBalloons(text: String): Int {
            val chars = IntArray(26) { 0 }
            for (c in text) {
                chars[c - 'a']++
            }
            var result = chars[0]
            result = minOf(result, chars['b' - 'a'])
            result = minOf(result, chars['l' - 'a'] / 2)
            result = minOf(result, chars['n' - 'a'])
            result = minOf(result, chars['o' - 'a'] / 2)
            return result
        }
    }
}
