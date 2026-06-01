package me.bossm0n5t3r.leetcode.checkifawordoccursasaprefixofanywordinasentence

class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    class Solution {
        fun isPrefixOfWord(sentence: String, searchWord: String): Int =
            " $sentence".split(" ").indexOfFirst { it.startsWith(searchWord) }
    }
}
