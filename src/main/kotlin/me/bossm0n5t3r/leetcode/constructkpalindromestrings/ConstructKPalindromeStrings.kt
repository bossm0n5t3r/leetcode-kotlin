package me.bossm0n5t3r.leetcode.constructkpalindromestrings

class ConstructKPalindromeStrings {
    class Solution {
        fun canConstruct(s: String, k: Int): Boolean {
            if (s.length < k) return false
            return s.groupingBy { it }.eachCount().values.count { it % 2 != 0 } <= k
        }
    }
}
