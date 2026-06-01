package me.bossm0n5t3r.leetcode.stringmatchinginanarray

class StringMatchingInAnArray {
    class Solution {
        fun stringMatching(words: Array<String>): List<String> {
            return words.filter {
                for (word in words) {
                    if (it != word && it in word) {
                        return@filter true
                    }
                }
                false
            }
        }
    }
}
