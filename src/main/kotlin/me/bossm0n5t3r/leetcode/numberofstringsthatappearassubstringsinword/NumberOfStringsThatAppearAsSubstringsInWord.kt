package me.bossm0n5t3r.leetcode.numberofstringsthatappearassubstringsinword

class NumberOfStringsThatAppearAsSubstringsInWord {
    class Solution {
        fun numOfStrings(patterns: Array<String>, word: String): Int {
            return patterns.count { it in word }
        }
    }
}
