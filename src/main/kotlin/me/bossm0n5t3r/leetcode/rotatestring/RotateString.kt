package me.bossm0n5t3r.leetcode.rotatestring

class RotateString {
    class Solution {
        fun rotateString(s: String, goal: String): Boolean {
            if (s == goal) return true
            if (goal.length != s.length) return false
            var tmp = ""
            val first = goal[0]
            for (i in s.indices) {
                if (first == s[i] && "${s.substring(tmp.length, s.length)}$tmp" == goal) {
                    return true
                }
                tmp += s[i]
            }
            return false
        }
    }
}
