package me.bossm0n5t3r.leetcode.countingwordswithagivenprefix

class CountingWordsWithAGivenPrefix {
    class Solution {
        fun prefixCount(words: Array<String>, pref: String): Int = words.count {
            it.startsWith(pref)
        }
    }
}
