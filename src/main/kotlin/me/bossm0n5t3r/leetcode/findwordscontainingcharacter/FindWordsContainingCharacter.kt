package me.bossm0n5t3r.leetcode.findwordscontainingcharacter

class FindWordsContainingCharacter {
    class Solution {
        fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
            val result = mutableListOf<Int>()
            for (i in words.indices) {
                for (c in words[i]) {
                    if (c == x) {
                        result += i
                        break
                    }
                }
            }
            return result
        }
    }
}
