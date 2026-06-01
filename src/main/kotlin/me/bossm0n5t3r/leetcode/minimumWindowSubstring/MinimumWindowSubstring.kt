package me.bossm0n5t3r.leetcode.minimumWindowSubstring

class MinimumWindowSubstring {
    class Solution {
        fun minWindow(s: String, t: String): String {
            val map = IntArray(128)
            for (c in t) {
                map[c.code]++
            }
            var left = 0
            var right = 0
            var start = 0
            var len = Int.MAX_VALUE
            var count = t.length
            while (right < s.length) {
                if (map[s[right].code] > 0) count--
                map[s[right].code]--
                right++
                while (count == 0) {
                    if (right - left < len) {
                        start = left
                        len = right - left
                    }
                    if (map[s[left].code] == 0) count++
                    map[s[left].code]++
                    left++
                }
            }
            return if (len == Int.MAX_VALUE) "" else s.substring(start, start + len)
        }
    }
}
