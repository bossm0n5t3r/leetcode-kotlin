package me.bossm0n5t3r.leetcode.groupAnagrams

class GroupAnagrams {
    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> =
            strs.groupBy { it.toCharArray().sorted() }.map { it.value }
    }
}
