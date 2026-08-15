package me.bossm0n5t3r.leetcode.validanagram

class ValidAnagram {
    class Solution {
        fun isAnagram(s: String, t: String): Boolean {
            val frequency = IntArray(26) { 0 }
            for (c in s) frequency[c - 'a']++
            for (c in t) frequency[c - 'a']--
            for (num in frequency) if (num != 0) return false
            return true
        }
    }
}
