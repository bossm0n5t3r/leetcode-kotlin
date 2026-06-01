package me.bossm0n5t3r.leetcode.uncommonwordsfromtwosentences

class UncommonWordsFromTwoSentences {
    class Solution {
        fun uncommonFromSentences(s1: String, s2: String): Array<String> =
            "$s1 $s2"
                .split(" ")
                .groupingBy { it }
                .eachCount()
                .filter { it.value == 1 }
                .keys
                .toTypedArray()
    }
}
