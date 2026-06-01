package me.bossm0n5t3r.leetcode.implementStrStr

class ImplementStrStr {
    class Solution {
        fun strStr(haystack: String, needle: String): Int {
            if (needle.isEmpty()) return 0
            if (needle.length > haystack.length) return -1
            val length = needle.length
            for (i in 0..(haystack.length - needle.length)) {
                val target = haystack.substring(i, i + length)
                if (target == needle) return i
            }
            return -1
        }

        fun strStrAt20250111(haystack: String, needle: String): Int {
            for (i in 0..haystack.length - needle.length) {
                if (haystack.substring(i, i + needle.length) == needle) {
                    return i
                }
            }
            return -1
        }
    }
}
