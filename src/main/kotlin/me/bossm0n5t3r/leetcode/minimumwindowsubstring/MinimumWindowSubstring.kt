package me.bossm0n5t3r.leetcode.minimumwindowsubstring

class MinimumWindowSubstring {
    class Solution {
        fun minWindow(s: String, t: String): String {
            val tFrequency = IntArray(123)
            for (c in t) tFrequency[c.code]++

            val required = tFrequency.count { it > 0 }
            val sFrequency = IntArray(123)

            var left = 0
            var formed = 0

            var resultStart = 0
            var resultLength = Int.MAX_VALUE

            for (right in s.indices) {
                val rc = s[right]
                sFrequency[rc.code]++
                if (tFrequency[rc.code] > 0 && sFrequency[rc.code] == tFrequency[rc.code]) {
                    formed++
                }
                while (formed == required) {
                    val windowLength = right - left + 1

                    if (windowLength < resultLength) {
                        resultStart = left
                        resultLength = windowLength
                    }

                    val lc = s[left]

                    if (tFrequency[lc.code] > 0 && sFrequency[lc.code] == tFrequency[lc.code]) {
                        formed--
                    }

                    sFrequency[lc.code]--
                    left++
                }
            }

            return if (resultLength == Int.MAX_VALUE) {
                ""
            } else {
                s.substring(resultStart, resultStart + resultLength)
            }
        }
    }
}
