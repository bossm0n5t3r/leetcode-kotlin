package me.bossm0n5t3r.leetcode.minimumwindowsubstring

class MinimumWindowSubstring {
    class Solution {
        private val lowercase = 'a'..'z'
        private val uppercase = 'A'..'Z'

        fun minWindow(s: String, t: String): String {
            val tFrequency = IntArray(123) { 0 }
            for (c in t) tFrequency[c.code]++
            var left = 0
            var result = ""
            val sFrequency = IntArray(123) { 0 }
            for (right in s.indices) {
                val cur = s[right]
                sFrequency[cur.code]++
                while (left < s.length && sFrequency.isContained(tFrequency)) {
                    val candidate = s.substring(left, right + 1)
                    if (result.isEmpty() || candidate.length < result.length) result = candidate

                    sFrequency[s[left].code]--
                    left++
                }
            }
            return result
        }

        private fun IntArray.isContained(other: IntArray): Boolean {
            for (l in lowercase) {
                if (this[l.code] < other[l.code]) return false
            }
            for (l in uppercase) {
                if (this[l.code] < other[l.code]) return false
            }
            return true
        }
    }
}
